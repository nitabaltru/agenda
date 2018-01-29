package model;

/**
 * The Contact entity class
 * 
 * @author Diana Baltrusaitis
 *
 */
public class Contact {
	private String name;
	private String surname;
	private String homePhone;
	private String cellPhone;
	private String officePhone;
	private String email;
	private String birthday;
	private String address;
	private String key;

	/**
	 * The default constructor.
	 */

	public Contact() {

	}

	/**
	 * The Contact constructor based on a fields array and a key string.
	 * 
	 * @param record
	 *            The records array
	 * @param key
	 *            They key associated to the contact
	 */
	public Contact(String[] record, String key) {

		for (int i = 0; i < 8; i++) {
			String prop = "";

			try {
				prop = record[i];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("The contact has some missing properties");
				prop = "";
			}

			assignProperty(prop, i);
		}

		this.setKey(key);
	}

	/* Setters */
	/**
	 * Set the contact's name
	 * 
	 * @param name
	 *            The name String
	 */
	public void setName(String name) {
		this.name = (name == null) ? "" : name;
	}

	/**
	 * Set the contact's surname
	 * 
	 * @param surname
	 *            The surname String
	 */
	public void setSurname(String surname) {
		this.surname = (surname == null) ? "" : surname;
	}

	/**
	 * Set the contact's home phone number
	 * 
	 * @param homePhone
	 *            The home phone String
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = (homePhone == null) ? "" : homePhone;
	}

	/**
	 * Set the contact's cell phone number
	 * 
	 * @param cellPhone
	 *            The cell phone String
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = (cellPhone == null) ? "" : cellPhone;
	}

	/**
	 * Set the contact's office phone number
	 * 
	 * @param officePhone
	 *            The cell
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = (officePhone == null) ? "" : officePhone;
	}

	/**
	 * Set the contact's Email
	 * 
	 * @param email
	 *            The email String
	 */
	public void setEmail(String email) {
		this.email = (email == null) ? "" : email;
	}

	/**
	 * Set the contact's birth date
	 * 
	 * @param birthday
	 *            The birthday String
	 */
	public void setBirthday(String birthday) {
		this.birthday = (birthday == null) ? "" : birthday;
	};

	/**
	 * Set the contact's address
	 * 
	 * @param address
	 *            The address String
	 */
	public void setAddress(String address) {
		this.address = (address == null) ? "" : address;
	};

	/**
	 * Set the contact's key
	 * 
	 * @param key
	 *            The key String
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/* Getters */

	/**
	 * Get the contact's name
	 * 
	 * @return The name String
	 */
	public String getName() {
		return this.name;
	};

	/**
	 * Get the contact's surname
	 * 
	 * @return The surname String
	 */
	public String getSurname() {
		return this.surname;
	};

	/**
	 * Get the contact's home phone
	 * 
	 * @return The home phone String
	 */
	public String getHomePhone() {
		return this.homePhone;
	};

	/**
	 * Get the contact's cell phone
	 * 
	 * @return The cell phone String
	 */
	public String getCellPhone() {
		return this.cellPhone;
	};

	/**
	 * Get the contact's office phone
	 * 
	 * @return The office phone String
	 */
	public String getOfficePhone() {
		return this.officePhone;
	};

	/**
	 * Get the contact's email
	 * 
	 * @return The email String
	 */
	public String getEmail() {
		return this.email;
	};

	/**
	 * Get the contact's birthday
	 * 
	 * @return The birthday String
	 */
	public String getBirthday() {
		return this.birthday;
	};

	/**
	 * Get the contact's address
	 * 
	 * @return The address String
	 */
	public String getAddress() {
		return this.address;
	};

	/**
	 * Get the contact's key
	 * 
	 * @return The key String
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Method override for showing properly the Contact's full name
	 * 
	 * @return The name String
	 */
	public String toString() {
		return this.name + " " + this.surname;
	}

	/**
	 * Method to properly assign the property to a contact, invoked by the
	 * constructor
	 * 
	 * @param prop
	 *            The property String
	 * @param i
	 *            the index to compare
	 */
	private void assignProperty(String prop, int i) {
		switch (i) {
		case 0:
			this.setName(prop);
			break;
		case 1:
			this.setSurname(prop);
			break;
		case 2:
			this.setHomePhone(prop);
			break;
		case 3:
			this.setOfficePhone(prop);
			break;
		case 4:
			this.setCellPhone(prop);
			break;
		case 5:
			this.setEmail(prop);
			break;
		case 6:
			this.setBirthday(prop);
			break;
		case 7:
			this.setAddress(prop);
			break;
		default:
			break;
		}
	}
}