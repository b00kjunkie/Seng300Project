package iteration_3;

/**
 * The PatientDB.java class is a subclass of the CustomArray class. It is intended to represent a database which stores
 * all patients that have registered for the system. Current data fields include: ID, Username, Password, Gender, DOB, 
 * HeartDisease, Diabetes, Anxiety. All fields are stored as strings for simplicity.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-10
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class PatientDB extends CustomArray { // Class represents the saved set of registered users

	private static final long serialVersionUID = 7L; // serial ID for java object saving

	/**
	 * Constructor with no parameters calls the super class constructor with no parameters.
	 * 
	 * @throws Exception
	 */
	protected PatientDB() throws Exception {
		super();
	}

	/**
	 * Constructor with string array parameter calls super class constructor, however, a check is performed to verify
	 * that the patient record (CustomElement) passed has length 9, so that each patient record has same form.
	 * 
	 * @param arr - type String[] of length 9 representing the patient record
	 * @throws Exception
	 */
	protected PatientDB(String[] arr) throws Exception {
		super(arr);
		if (arr.length != 9) {
			throw new Exception(
					"PatientDB elements must have form: [ID, Username, Name, Password, Gender, DOB, HeartDisease, Diabetes, Anxiety] ");
		}
	}

	/**
	 * Method adds a patient record (CustomElement) to the patient database. Verifies that passed record has length 9.
	 */
	protected void add(String[] arr) throws Exception {
		if (arr.length == 9) {
			super.add(arr);
		} else {
			throw new Exception(
					"PatientDB elements must have form: [ID, Username, Password, Name, Gender, DOB, HeartDisease, Diabetes, Anxiety] ");
		}
	}

	/**
	 * Method returns the ID number corresponding to a given username and password match.
	 * 
	 * @param username - type String
	 * @param password - type String
	 * @return ID of type String
	 * @throws Exception
	 */
	protected String getID(String username, String password) throws Exception {
		
		
		return this.search(username, 1).search(password, 2).get(0).getCustomElement()[0];
	}

	/**
	 * Method returns the ID number corresponding to a given patient name
	 * 
	 * @param name of type String
	 * @return patient ID of type String
	 * @throws Exception
	 */
	protected String matchNameToID(String name) throws Exception {
		String result = "";
		try {
			result = this.search(name, 3).get(0).getCustomElement()[0];

		} catch (Exception e1) {
		}
		return result;
	}

	/**
	 * Method checks if there is a patient record that matches the username and password parameters.
	 * 
	 * @param username - type String
	 * @param password - type String
	 * @return boolean result indicating if there was a match
	 * @throws Exception
	 */
	protected boolean checkForMatch(String username, String password) throws Exception {
		if (this.search(username, 1).search(password, 2).isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Method checks if the username parameter is already in the patient database as a username
	 * 
	 * @param username - type String
	 * @return boolean indicating if the username is available (hasn't been registered already)
	 */
	protected boolean usernameAvailable(String username) {

		for (int i = 0; i < this.customArray.size(); i++) {

			if (this.customArray.get(i).getCustomElement()[1].equalsIgnoreCase(username)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method returns the String array that represents a patient record.
	 * 
	 * @param id - type String
	 * @return String[] containing the 9 elements of a patient record
	 */
	protected String[] getPatientRecord(String id) {

		for (int i = 0; i < customArray.size(); i++) {
			if (customArray.get(i).getCustomElement()[0].equalsIgnoreCase(id)) {
				return customArray.get(i).getCustomElement().clone();
			}
		}
		return null;
	}

	/**
	 * Saves the calling PatientDB object to a text file
	 * 
	 * @throws Exception
	 */
	protected void savePatientDB() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("patientDB.txt"))) {
			out.writeObject(this);
		} catch (Exception e) {
			throw new Exception("Not saved properly");
		}
	}

	/**
	 * Loads a PatientDB object from a text file. If method cannot successfully load patientDB.txt, then the database is
	 * reinitialized using the reinitDB() method.
	 * 
	 * @return PatientDB object
	 * @throws Exception
	 */
	protected PatientDB loadPatientDB() throws Exception {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("patientDB.txt"))) {
			return (PatientDB) in.readObject();
		} catch (Exception e) {
			PatientDB.reinitDB();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("patientDB.txt"))) {
				return (PatientDB) in.readObject();
			} catch (Exception e1) {
				throw new Exception("Load unsuccessful");
			}
		}
	}

	/**
	 * Method restores the patient database to a simple/original form, as testing purposes will likely add many patients
	 * to the database which can get cluttered. Also is used when loading database from a different computer, as file
	 * may not be present
	 * 
	 * @throws Exception
	 */
	protected static void reinitDB() throws Exception {
		PatientDB constructDB = new PatientDB(
				new String[] { "1", "NoahBensler", "12345678", "Noah", "M", "01/01/1990", "Y", "N", "Y" });
		constructDB.add(new String[] { "2", "JamesLiu", "12345678", "James", "M", "09/09/1990", "N", "N", "N" });
		constructDB.add(new String[] { "3", "VuNguyen", "12345678", "Vu", "M", "09/09/1990", "N", "N", "N" });
		constructDB.add(new String[] { "4", "BoyangDong", "12345678", "Bo", "M", "09/09/1990", "N", "N", "N" });
		constructDB.add(new String[] { "5", "KenSharman", "12345678", "Ken", "M", "09/09/1990", "N", "N", "N" });
		constructDB.savePatientDB();
	}

} // end class PatientDB