package iteration_3;

/**
 * The DoctorDB.java class is a subclass of the CustomArray class. It is intended to represent a database which stores
 * all doctors that have been registered for the system. Current data fields include: ID, Username, Password, Name, 
 * Gender, and Department. All fields are stored as strings for simplicity.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class DoctorDB extends CustomArray { // Class represents the saved set of registered doctors

	private static final long serialVersionUID = 8L; // serial ID for java object saving

	/**
	 * Constructor with no parameters calls the super class constructor with no parameters.
	 * 
	 * @throws Exception
	 */
	protected DoctorDB() throws Exception {
		super();
	}

	/**
	 * Constructor with string array parameter calls super class constructor, however, a check is performed to verify
	 * that the doctor record (CustomElement) passed has length 6, so that each doctor record has same form.
	 * 
	 * @param arr - type String[] of length 6 representing the doctor record
	 * @throws Exception
	 */
	protected DoctorDB(String[] arr) throws Exception {
		super(arr);
		if (arr.length != 6) {
			throw new Exception("DoctorDB elements must have form: [ID, Username, Password, Name, Gender, Department]");
		}
	}

	/**
	 * Method adds a doctor record (CustomElement) to the doctor database. Verifies that passed record has length 6.
	 */
	protected void add(String[] arr) throws Exception {
		if (arr.length == 6) {
			super.add(arr);
		} else {
			throw new Exception("DoctorDB elements must have form: [ID, Username, Password, Name, Gender, Department]");
		}
	}

	/**
	 * Method returns the String array that represents a doctor record.
	 * 
	 * @param id - type String
	 * @return String[] containing the 6 elements of a doctor record
	 */
	protected String[] getDoctorRecord(String id) {

		for (int i = 0; i < customArray.size(); i++) {
			if (customArray.get(i).getCustomElement()[0].equalsIgnoreCase(id)) {
				return customArray.get(i).getCustomElement().clone();
			}
		}
		return null;
	}

	/**
	 * Method returns all instances of doctor records, where the doctor has the same department as the one indicated by
	 * the parameter
	 * 
	 * @param depart of type string representing the department to be search for
	 * @return CustomArray containing all doctors who have the indicated department set
	 * @throws Exception
	 */
	protected CustomArray findDoctorsInDepartment(String depart) throws Exception {
		return this.search(depart, 5);
	}

	/**
	 * Saves the calling DoctorDB object to a text file
	 * 
	 * @throws Exception
	 */
	protected void saveDoctorDB() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("doctorDB.txt"))) {
			out.writeObject(this);
		} catch (Exception e) {
			throw new Exception("Not saved properly");
		}
	}

	/**
	 * Loads the DoctorDB object from doctorDB.txt
	 * 
	 * @return DoctorDB object
	 * @throws Exception
	 */
	protected DoctorDB loadDoctorDB() throws Exception {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("doctorDB.txt"))) {
			return (DoctorDB) in.readObject();
		} catch (Exception e) {
			DoctorDB.initDoctorDB();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("doctorDB.txt"))) {
				return (DoctorDB) in.readObject();
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
	protected static void initDoctorDB() throws Exception {
		DoctorDB constructDB = new DoctorDB(new String[] { "1", "doc1", "12345678", "Phil McGraw", "M", "Emergency " });
		constructDB.add(new String[] { "2", "doc2", "12345678", "Mehmet Oz", "M", "Cardiology" });
		constructDB.add(new String[] { "3", "doc3", "12345678", "John Smith", "M", "ICU       " });
		constructDB.add(new String[] { "4", "doc4", "12345678", "Elias Hawkins", "M", "Neurology " });
		constructDB.add(new String[] { "5", "doc5", "12345678", "Demi Burgess", "F", "Emergency " });
		constructDB.add(new String[] { "6", "doc6", "12345678", "Lara Andersen", "F", "ICU       " });
		constructDB.saveDoctorDB();
	}

} // end class DoctorDB
