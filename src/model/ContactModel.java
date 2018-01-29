package model;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * The model class to interact to serve as a bridge between the view and the
 * data.
 * 
 * @author Diana Baltrusaitis
 *
 */
public class ContactModel {

	private FileManager manager;

	/**
	 * The default constructor
	 */
	public ContactModel() {
		manager = new FileManager();
	}

	/**
	 * Retrieve the contact list associated to the selected agenda
	 * 
	 * @return The Contact list
	 */
	public Contact[] getContactList() {

		Properties properties = manager.getFileProperties();
		Contact contacts[] = new Contact[properties.size()];
		Enumeration keys = properties.keys();
		String key, cString;
		int i = 0;

		while (keys.hasMoreElements()) {
			key = keys.nextElement().toString();
			cString = properties.getProperty(key);
			contacts[i] = new Contact(cString.split(","), key);
			i++;
		}

		return contacts;
	}

	/**
	 * Save a contact
	 * 
	 * @param contact
	 *            The Contact object to save on file
	 */

	public void saveContact(Contact contact) {
		String cString = "";

		cString += contact.getName();
		cString += "," + contact.getSurname();
		cString += "," + contact.getHomePhone();
		cString += "," + contact.getOfficePhone();
		cString += "," + contact.getCellPhone();
		cString += "," + contact.getEmail();
		cString += "," + contact.getBirthday();
		cString += "," + contact.getAddress();

		manager.savePropertyOnFile(cString, contact.getKey());
	}

	/**
	 * Get the contact's list size
	 * 
	 * @return The contact list size
	 */
	public int getContactSize() {
		return manager.getFileProperties().size();
	}

	/**
	 * Delete a contact from the properties file
	 * 
	 * @param contact
	 *            The contact to be deleted
	 */
	public void deleteContact(Contact contact) {
		manager.deletePropertyFromFile(contact.getKey());
	}

	/**
	 * Get contact's file manager
	 * 
	 * @return The file manager
	 */
	public FileManager getFileManager() {
		return this.manager;
	}
}