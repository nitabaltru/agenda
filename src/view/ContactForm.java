package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import model.Contact;


/**
 * The application Contact Form. This holds all the fields and labels related to
 * the CRUD operations on the agenda.
 * 
 * 
 * @author Diana Baltrusaitis
 *
 */
public class ContactForm {

	protected JTextField name;
	protected JTextField surname;
	protected JTextField homePhone;
	protected JTextField cellPhone;
	protected JTextField officePhone;
	protected JTextField email;
	protected JTextField address;
	protected JTextField birthday;

	protected JLabel nameLabel;
	protected JLabel surnameLabel;
	protected JLabel homePhoneLabel;
	protected JLabel cellPhoneLabel;
	protected JLabel officePhoneLabel;
	protected JLabel emailLabel;
	protected JLabel addressLabel;
	protected JLabel birthdayLabel;

	protected JButton save;
	protected JButton delete;
	protected JButton add;

	protected JPanel container;

	/**
	 * The class constructor
	 */
	public ContactForm() {
		name = new JTextField();
		surname = new JTextField();
		homePhone = new JTextField();
		cellPhone = new JTextField();
		officePhone = new JTextField();
		email = new JTextField();
		address = new JTextField();
		birthday = new JTextField();

		nameLabel = new JLabel("Name");
		surnameLabel = new JLabel("Surname");
		homePhoneLabel = new JLabel("Home");
		cellPhoneLabel = new JLabel("Cellphone");
		officePhoneLabel = new JLabel("Office");
		emailLabel = new JLabel("Email");
		addressLabel = new JLabel("Address");
		birthdayLabel = new JLabel("Birthday");

		String path = new File("").getAbsolutePath();

		ImageIcon icon_save = new ImageIcon(path + "/src/images/check.png");
		Image img = icon_save.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_save = new ImageIcon(img);
		save = new JButton("Save", icon_save);

		ImageIcon icon_delete = new ImageIcon(path + "/src/images/delete.png");
		img = icon_delete.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_delete = new ImageIcon(img);
		delete = new JButton("Delete", icon_delete);

		ImageIcon icon_new = new ImageIcon(path + "/src/images/add.png");
		img = icon_new.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_new = new ImageIcon(img);
		add = new JButton("New", icon_new);

		configElements();
	}

	/**
	 * Retrieve the Contact Form container
	 * 
	 * @return the form container
	 */
	public JPanel getForm() {
		return this.container;
	}

	/**
	 * Set the fields' values through a Contact object
	 * 
	 * @param contact
	 *            The Contact object
	 */

	public void setValues(Contact contact) {
		name.setText(contact.getName());
		surname.setText(contact.getSurname());
		homePhone.setText(contact.getHomePhone());
		officePhone.setText(contact.getOfficePhone());
		cellPhone.setText(contact.getCellPhone());
		email.setText(contact.getEmail());
		address.setText(contact.getAddress());
		birthday.setText(contact.getBirthday());

		refresh();
	}

	/**
	 * Config Contact Form elements and draw them on the panel container
	 */

	private void configElements() {

		Font font1 = new Font("Courier", Font.BOLD, 14);
		Font font2 = new Font("Courier", Font.BOLD, 18);

		nameLabel.setFont(font1);
		surnameLabel.setFont(font1);
		homePhoneLabel.setFont(font1);
		cellPhoneLabel.setFont(font1);
		officePhoneLabel.setFont(font1);
		emailLabel.setFont(font1);
		addressLabel.setFont(font1);
		birthdayLabel.setFont(font1);

		add.setFont(font2);
		save.setFont(font2);
		delete.setFont(font2);
		nameLabel.setBounds(50, 50, 145, 25);
		name.setBounds(145, 50, 145, 25);

		surnameLabel.setBounds(350, 50, 145, 25);
		surname.setBounds(450, 50, 165, 25);

		homePhoneLabel.setBounds(50, 100, 145, 25);
		homePhone.setBounds(145, 100, 145, 25);

		cellPhoneLabel.setBounds(350, 100, 145, 25);
		cellPhone.setBounds(450, 100, 165, 25);

		officePhoneLabel.setBounds(50, 150, 145, 25);
		officePhone.setBounds(145, 150, 145, 25);

		emailLabel.setBounds(350, 150, 145, 25);
		email.setBounds(450, 150, 165, 25);

		addressLabel.setBounds(50, 200, 145, 25);
		address.setBounds(145, 200, 145, 25);

		birthdayLabel.setBounds(350, 200, 145, 25);
		birthday.setBounds(450, 200, 165, 25);

		add.setBounds(50, 350, 165, 40);
		save.setBounds(240, 350, 185, 40);
		delete.setBounds(450, 350, 175, 40);

		container = new JPanel();
		container.setBackground(Color.white);
		container.setBounds(240, 10, 640, 570);
		container.add(name);
		container.add(surname);
		container.add(homePhone);
		container.add(cellPhone);
		container.add(officePhone);
		container.add(email);
		container.add(address);
		container.add(birthday);

		container.add(nameLabel);
		container.add(surnameLabel);
		container.add(homePhoneLabel);
		container.add(cellPhoneLabel);
		container.add(officePhoneLabel);
		container.add(emailLabel);
		container.add(addressLabel);
		container.add(birthdayLabel);

		container.add(save);
		container.add(delete);
		container.add(add);

		container.setLayout(new BorderLayout());
	}

	/**
	 * Remove the content from all the text fields
	 */
	public void clearFields() {
		name.setText("");
		surname.setText("");
		homePhone.setText("");
		officePhone.setText("");
		cellPhone.setText("");
		email.setText("");
		address.setText("");
		birthday.setText("");
	}

	/**
	 * Repaint the container
	 */
	private void refresh() {
		container.repaint();
	}
}
