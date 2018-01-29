package view;

import javax.swing.JMenuBar;

import java.awt.Image;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * The Agenda Menu class. This is treated as external component and can be
 * inherited into the main view class
 * 
 * @author Diana Baltrusaitis
 *
 */
public class AgendaMenu {
	private JMenuBar menubar;

	private JMenu fileMenu;
	private JMenu optionsMenu;
	private JMenu languageMenu;

	private JMenuItem fileNewAgenda;
	private JMenuItem fileOpen;
	private JMenuItem fileExit;
	private JMenuItem fileSaveAs;

	private JMenuItem frenchMenu;
	private JMenuItem englishMenu;
	private JMenuItem spanishMenu;
	private JMenuItem germanMenu;

	/**
	 * The class constructor
	 */
	public AgendaMenu() {
		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		optionsMenu = new JMenu("Options");
		languageMenu = new JMenu("Language");

		fileNewAgenda = new JMenuItem("New agenda");
		fileOpen = new JMenuItem("Open");
		fileSaveAs = new JMenuItem("Save as...");
		fileExit = new JMenuItem("Exit");

		fileMenu.add(fileNewAgenda);
		fileMenu.add(fileOpen);
		fileMenu.add(fileSaveAs);
		fileMenu.add(fileExit);

		optionsMenu.add(languageMenu);

		String path = new File("").getAbsolutePath();

		ImageIcon icon_save = new ImageIcon(path + "/src/images/germany.png");
		Image img = icon_save.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_save = new ImageIcon(img);
		germanMenu = new JMenuItem("German", icon_save);

		icon_save = new ImageIcon(path + "/src/images/england.png");
		img = icon_save.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_save = new ImageIcon(img);
		englishMenu = new JMenuItem("English", icon_save);

		icon_save = new ImageIcon(path + "/src/images/france.png");
		img = icon_save.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_save = new ImageIcon(img);
		frenchMenu = new JMenuItem("French", icon_save);

		icon_save = new ImageIcon(path + "/src/images/spain.png");
		img = icon_save.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon_save = new ImageIcon(img);
		spanishMenu = new JMenuItem("Spanish", icon_save);

		languageMenu.add(germanMenu);
		languageMenu.add(englishMenu);
		languageMenu.add(frenchMenu);
		languageMenu.add(spanishMenu);

		menubar.add(fileMenu);
		menubar.add(optionsMenu);

		menubar.setVisible(true);

	}

	/**
	 * Retrieve the Menu Bar
	 * 
	 * @return The Menu Bar
	 */
	public JMenuBar getMenu() {
		return this.menubar;
	}

	/**
	 * Retrieve the New Agenda submenu
	 * 
	 * @return the New Agenda Submenu
	 */
	public JMenuItem getFileNewAgenda() {
		return this.fileNewAgenda;
	}

	/**
	 * Retrieve the Open submenu
	 * 
	 * @return the Open Submenu
	 */
	public JMenuItem getFileOpen() {
		return this.fileOpen;
	}

	/**
	 * Retrieve the Save as submenu
	 * 
	 * @return the Save as Submenu
	 */
	public JMenuItem getFileSaveAs() {
		return this.fileSaveAs;
	}

	/**
	 * Retrieve the Exit submenu
	 * 
	 * @return the Exit Submenu
	 */
	public JMenuItem getFileExit() {
		return this.fileExit;
	}

	/**
	 * Retrieve the French language submenu
	 * 
	 * @return the French Submenu
	 */
	public JMenuItem getFrenchMenu() {
		return this.frenchMenu;
	}

	/**
	 * Retrieve the English language submenu
	 * 
	 * @return the English Submenu
	 */
	public JMenuItem getEnglishMenu() {
		return this.englishMenu;
	}

	/**
	 * Retrieve the Spanish language submenu
	 * 
	 * @return the Spanish Submenu
	 */
	public JMenuItem getSpanishMenu() {
		return this.spanishMenu;
	}

	/**
	 * Retrieve the Deutsch language submenu
	 * 
	 * @return the Deutsch submenu
	 */
	public JMenuItem getDeutschMenu() {
		return this.germanMenu;
	}

	/**
	 * Update buttons strings on the interface according to language selected
	 * 
	 * @param language.
	 *            the language selected
	 */
	public void updateMenuLanguage(String language) {
		Locale locale = new Locale(language);
		ResourceBundle bundle = ResourceBundle.getBundle("languages.language", locale);

		fileMenu.setText(bundle.getString("file"));
		optionsMenu.setText(bundle.getString("options"));
		languageMenu.setText(bundle.getString("language"));
		fileNewAgenda.setText(bundle.getString("newAgenda"));
		fileOpen.setText(bundle.getString("open"));
		fileSaveAs.setText(bundle.getString("saveAs"));
		fileExit.setText(bundle.getString("exit"));
		germanMenu.setText(bundle.getString("german"));
		englishMenu.setText(bundle.getString("english"));
		frenchMenu.setText(bundle.getString("french"));
		spanishMenu.setText(bundle.getString("spanish"));

	}

}