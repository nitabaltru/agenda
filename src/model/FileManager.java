package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.JDialog;
import javax.swing.JFileChooser;


/**
 * The file manager class. This class is the one responsible for managing the
 * data on the files and performing all the operations on them
 * 
 * @author Diana Baltrusaitis
 *
 */
public class FileManager {
	private File manager;
	private FileReader reader;
	private FileWriter writer;
	private Properties properties;
	private JFileChooser chooser;
	private JDialog dialog;
	private String basePath = "src/assets/basePath.dt";
	private Preferences preferences;

	/**
	 * The default constructor
	 */
	public FileManager() {
		dialog = new JDialog();
		chooser = new JFileChooser();
		properties = new Properties();
		preferences = Preferences.userNodeForPackage(FileManager.class);
		loadPrefs();
	}

	/**
	 * Get the properties objects from the file
	 * 
	 * @return The properties object
	 */
	public Properties getFileProperties() {
		return this.properties;
	}

	/**
	 * Save a property object on the currently selected file
	 * 
	 * @param cString
	 *            The contact string
	 * @param key
	 *            The associated key
	 * 
	 */
	public void savePropertyOnFile(String cString, String key) {
		this.properties.setProperty(key, cString);
		writeToFile();
	}

	/**
	 * Delete property object from the file
	 * 
	 * @param key
	 *            The key associated to the property
	 */
	public void deletePropertyFromFile(String key) {
		this.properties.remove(key);
		writeToFile();
	}

	/**
	 * Load a file on the manager based on a specified path
	 * 
	 * @param path
	 *            The path to be loaded into the manager
	 * @return true if successful, false otherwise.
	 */
	private boolean loadFile(String path) {
		boolean loaded = false;
		System.out.println("Loading file: " + path);
		try {
			this.manager = new File(path);
			this.reader = new FileReader(this.manager.getAbsolutePath());
			this.properties = new Properties();
			this.properties.load(reader);
			loaded = true;
		} catch (FileNotFoundException e) {
			System.out.println("File:  " + this.manager.getAbsolutePath() + " was not found");
		} catch (IOException e) {
			System.out.println("There was a problem reading the contact file");
		} catch (NullPointerException e) {
			System.out.println("No such file: " + path);
		}
		return loaded;
	}

	/**
	 * Write a the properties object into the file associated to this manager
	 * 
	 */
	public void writeToFile() {
		try {
			writer = new FileWriter(this.manager.getAbsolutePath());
			this.properties.store(writer, "");
		} catch (IOException e) {
			System.out.println("There was a problem reading the contact file");
		} catch (Exception e) {
			System.out.println("Exception while writing contact file: " + e.getMessage());
		}
	}

	/**
	 * Load the user preferences
	 */
	public void loadPrefs() {
		this.basePath = preferences.get("filename", "");

		System.out.println("Loaded filename: " + preferences.get("filename", ""));
		System.out.println("Loaded lang: " + preferences.get("lang", ""));

		if (!loadFile(this.basePath)) {
			launchDirectoryChooser(true);
		}

		System.out.println("Loaded agenda: " + this.manager.getAbsolutePath());
	}

	/**
	 * Set the user's language preference
	 * 
	 * @param lang
	 *            The specified language
	 */

	public void setLanguagePref(String lang) {
		this.preferences.put("lang", lang);
	}

	/**
	 * Get the user's language preference
	 * 
	 * @return The language preference
	 */
	public String getLanguagePref() {
		return this.preferences.get("lang", "en");
	}

	/**
	 * Point this manager to the file specified on preferences
	 */
	public void setToPreferenceFile() {
		loadFile(this.basePath);
	}

	/**
	 * Launch the Directory Chooser dialog
	 * 
	 * @param save
	 *            Specify if the dialog should be launched in save mode
	 */
	public void launchDirectoryChooser(boolean save) {
		Locale locale = new Locale(this.getLanguagePref());
		ResourceBundle bundle = ResourceBundle.getBundle("languages.language", locale);
		
		chooser.setCurrentDirectory(new File(System.getProperty("user.home"), "Desktop"));
		chooser.setDialogTitle(bundle.getString("chooser"));
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setBounds(450, 150, 250, 150);
		chooser.setVisible(true);

		if (save)
			launchSaveDialog();
		else
			launchLoadDialog();
	}

	/**
	 * Clear the properties object
	 */
	public void clearProperties() {
		properties = new Properties();
	}

	/**
	 * Remove the existing preferences
	 */
	public void clearPreferences() {
		preferences.remove("filename");
		preferences.remove("lang");
	}

	/**
	 * Launches a Save Dialog and saves its path to the user's preferences
	 */
	private void launchSaveDialog() {
		chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);

		if (chooser.showSaveDialog(dialog) == JFileChooser.APPROVE_OPTION) {
			Properties data = properties;
			preferences.put("filename", chooser.getSelectedFile().getAbsolutePath());
			loadFile(chooser.getSelectedFile().getAbsolutePath());
			properties = data;
			this.writeToFile();
		} else {
			System.out.println("No Selection ");
			if (preferences.get("filename", "").equals("")) {
				System.exit(0);
			}
		}
	}

	/**
	 * Launches a Load Dialog and saves the specified path to the user's preferences
	 */
	private void launchLoadDialog() {
		chooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
		if (chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) {
			preferences.put("filename", chooser.getSelectedFile().getAbsolutePath());
			loadFile(chooser.getSelectedFile().getAbsolutePath());
		} else {
			System.out.println("No Selection ");
			loadFile(this.basePath);
		}
	}
}
