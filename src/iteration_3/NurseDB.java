package iteration_3;

/**
 * The NurseDB.java class is a subclass of the CustomArray class. It is intended to represent a database which stores
 * all nurses that have been registered for the system. Current data fields include: ID, Username, Password, Name, 
 * Gender, and Department. All fields are stored as strings for simplicity.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class NurseDB extends CustomArray { // Class represents the saved set of registered nurses

	private static final long serialVersionUID = 15L; // serial ID for java object saving

	/**
	 * Constructor with no parameters calls the super class constructor with no parameters.
	 * 
	 * @throws Exception
	 */
	protected NurseDB() throws Exception {
		super();
	}

	/**
	 * Constructor with string array parameter calls super class constructor, however, a check is performed to verify
	 * that the nurse record (CustomElement) passed has length 6, so that each doctor record has same form.
	 * 
	 * @param arr - type String[] of length 6 representing the nurse record
	 * @throws Exception
	 */
	protected NurseDB(String[] arr) throws Exception {
		super(arr);
		if (arr.length != 6) {
			throw new Exception("NurseDB elements must have form: [ID, Username, Password, Name, Gender, Department]");
		}
	}

	/**
	 * Method adds a nurse record (CustomElement) to the doctor database. Verifies that passed record has length 6.
	 */
	protected void add(String[] arr) throws Exception {
		if (arr.length == 6) {
			super.add(arr);
		} else {
			throw new Exception("NurseDB elements must have form: [ID, Username, Password, Name, Gender, Department]");
		}
	}

	/**
	 * Method returns the String array that represents a nurse record.
	 * 
	 * @param id - type String
	 * @return String[] containing the 6 elements of a nurse record
	 */
	protected String[] getNurseRecord(String id) {

		for (int i = 0; i < customArray.size(); i++) {
			if (customArray.get(i).getCustomElement()[0].equalsIgnoreCase(id)) {
				return customArray.get(i).getCustomElement().clone();
			}
		}
		return null;
	}

	/**
	 * Saves the calling NurseDB object to a text file
	 * 
	 * @throws Exception
	 */
	protected void saveNurseDB() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("nurseDB.txt"))) {
			out.writeObject(this);
		} catch (Exception e) {
			throw new Exception("Not saved properly");
		}
	}

	/**
	 * Loads the NurseDB object from nurseDB.txt
	 * 
	 * @return DoctorDB object
	 * @throws Exception
	 */
	protected NurseDB loadNurseDB() throws Exception {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("nurseDB.txt"))) {
			return (NurseDB) in.readObject();
		} catch (Exception e) {
			NurseDB.initNurseDB();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("nurseDB.txt"))) {
				return (NurseDB) in.readObject();
			} catch (Exception e1) {
				throw new Exception("Load unsuccessful");
			}
		}
	}

	/**
	 * Method initializes the doctor database to a set form. System administrator can change the registered doctor list
	 * by modifying this method.
	 * 
	 * @throws Exception
	 */
	protected static void initNurseDB() throws Exception {
		NurseDB constructDB = new NurseDB(new String[] { "1", "nurse1", "12345678", "Brad Pitt", "M", "Radiology" });
		constructDB.add(new String[] { "2", "nurse2", "12345678", "George Clooney", "M", "ICU" });
		constructDB.saveNurseDB();
	}

} // end class NurseDB
