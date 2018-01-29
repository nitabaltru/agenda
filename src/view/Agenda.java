package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ResourceBundle;

import model.ContactModel;
import model.Contact;

/**
 * Main view of the application. Here is which most of the events are handled
 * and through model the data is treated.
 * 
 * @author Diana Baltrusaitis
 *
 */
public class Agenda extends ContactForm {
	private JFrame window;
	private JPanel globalContainer;
	private JList<Contact> list;
	private JScrollPane leftContainer;
	private DefaultListModel<Contact> listModel;
	private ContactModel model;
	private Locale locale;
	private AgendaMenu menu;
	private ResourceBundle bundle;
	private boolean newContact;

	/* right container */
	private JPanel rightContainer;

	/* north container */
	private JPanel northContainer;

	/**
	 * The class constructor
	 */
	public Agenda() {
		listModel = new DefaultListModel<Contact>();
		list = new JList<Contact>(listModel);
		leftContainer = new JScrollPane(list);
		window = new JFrame();
		model = new ContactModel();
		menu = new AgendaMenu();
		locale = new Locale(model.getFileManager().getLanguagePref());
		bundle = ResourceBundle.getBundle("languages.language", locale);

		// model.getFileManager().clearPreferences();

		configElements();
		configureEvents();
	};

	/**
	 * Fill in the contact list. If no agenda file is detected a new one will be
	 * asked to be created in wich the files will be saved.
	 */
	public void populateContactsList() {
		Contact[] contacts = model.getContactList();

		for (int i = 0; i < contacts.length; i++) {
			listModel.addElement(contacts[i]);
		}

		// change font size
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);
		refresh();
	}

	/**
	 * Configuration of the inner elements and drawing on the Frame.
	 */
	private void configElements() {
		String path = new File("").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path + "/src/images/logo.jpg");
		JLabel label = new JLabel();

		// leftContainer.setBounds(10, 10, 150, 572);

		window.setSize(950, 650);
		window.setLocation(145, 100);
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Agenda Inc.");

		label.setIcon(icon);

		/* the globalContainer */
		globalContainer = new JPanel();
		globalContainer.setLayout(new BorderLayout());
		globalContainer.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#1098DA")));

		/* the northContainer */
		northContainer = new JPanel();
		northContainer.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#1098DA")));
		northContainer.setLocation(0, 100);
		northContainer.setBackground(Color.WHITE);
		northContainer.add(label);

		/* the leftContainer */
		list.setFixedCellWidth(265);

		/* the rightContainer */
		rightContainer = this.container;
		rightContainer.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.decode("#1098DA")));

		globalContainer.add(rightContainer, BorderLayout.CENTER);
		globalContainer.add(northContainer, BorderLayout.NORTH);
		globalContainer.add(leftContainer, BorderLayout.WEST);

		updateLabelLanguage(locale.getLanguage());

		window.setJMenuBar(menu.getMenu());
		window.setContentPane(globalContainer);
		window.setResizable(false);
		window.setVisible(true);
	}

	/**
	 * Component's events configuration
	 */
	private void configureEvents() {
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null)
					setValues(list.getSelectedValue());
			}
		});

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Saving contact");
				Random random = new Random(System.currentTimeMillis());
				Contact contact;

				if (newContact || list.getComponentCount() == 0 || listModel.size() == 0) {
					contact = new Contact();
					contact.setKey(String.valueOf(random.nextInt(65535)));
					listModel.addElement(contact);
				} else {
					contact = list.getSelectedValue();
				}

				contact.setName(name.getText());
				contact.setSurname(surname.getText());
				contact.setHomePhone(homePhone.getText());
				contact.setOfficePhone(officePhone.getText());
				contact.setCellPhone(cellPhone.getText());
				contact.setEmail(email.getText());
				contact.setBirthday(birthday.getText());
				contact.setAddress(address.getText());

				model.saveContact(contact);

				list.setSelectedIndex(listModel.getSize() - 1);

				newContact = false;

				refresh();
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Contact contact = list.getSelectedValue();
				model.deleteContact(contact);
				list.setSelectedIndex(list.getComponentCount() - 1);
				listModel.removeElement(contact);
				clearFields();
			}
		});

		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
				newContact = true;
			}
		});

		menu.getEnglishMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage("en");
			}
		});

		menu.getDeutschMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage("de");
			}
		});

		menu.getFrenchMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage("fr");
			}
		});

		menu.getSpanishMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateLabelLanguage("es");
			}
		});

		menu.getFileExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.getFileNewAgenda().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.getFileManager().writeToFile();
				listModel.removeAllElements();
				clearFields();

				model.getFileManager().clearProperties();
				model.getFileManager().launchDirectoryChooser(true);
			}
		});

		menu.getFileOpen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.getFileManager().setToPreferenceFile();
				model.getFileManager().launchDirectoryChooser(false);
				list.setSelectedIndex(0);
				listModel.removeAllElements();
				populateContactsList();
			}
		});

		menu.getFileSaveAs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.getFileManager().launchDirectoryChooser(true);
				list.setSelectedIndex(0);
				listModel.removeAllElements();
				populateContactsList();
			}
		});
	}

	/**
	 * Update label and buttons strings on the interface according to language
	 * selected
	 * 
	 * @param language.
	 *            the language selected
	 */
	private void updateLabelLanguage(String language) {
		locale = new Locale(language);
		bundle = ResourceBundle.getBundle("languages.language", locale);

		this.model.getFileManager().setLanguagePref(language);

		this.nameLabel.setText(bundle.getString("name"));
		this.surnameLabel.setText(bundle.getString("surname"));
		this.homePhoneLabel.setText(bundle.getString("home"));
		this.officePhoneLabel.setText(bundle.getString("office"));
		this.cellPhoneLabel.setText(bundle.getString("cellphone"));
		this.emailLabel.setText(bundle.getString("email"));
		this.addressLabel.setText(bundle.getString("address"));
		this.birthdayLabel.setText(bundle.getString("birthday"));

		this.add.setText(bundle.getString("new"));
		this.save.setText(bundle.getString("save"));
		this.delete.setText(bundle.getString("delete"));

		this.menu.updateMenuLanguage(language);
	}

	/**
	 * List and frame repainting to update view.
	 */
	private void refresh() {
		leftContainer.repaint();
		window.repaint();
	}

}
