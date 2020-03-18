package iteration_2;

/**
 * The DoctorUnavailabilityDB.java class is a subclass of the CustomArray class. It is intended to represent a database
 * which stores the unavailability for all registered doctors. Current data fields include: Doctor ID, Date, and Time.
 * All fields are stored as strings for simplicity.
 * 
 * @author SENG 300 Group 12 - Winter 2020 Date: 2020-03-16
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DoctorUnavailabilityDB extends CustomArray { // Class represents the saved set of registered doctors

	private static final long serialVersionUID = 11L; // serial ID for java object saving

	/**
	 * Constructor with no parameters calls the super class constructor with no parameters.
	 * 
	 * @throws Exception
	 */
	protected DoctorUnavailabilityDB() throws Exception {
		super();
	}

	/**
	 * Method adds a availability record (CustomElement) to the Doctor Unavailability database. Verifies that passed
	 * record has length 3.
	 */
	protected void add(String[] arr) throws Exception {
		if (arr.length == 3) {
			super.add(arr);
		} else {
			throw new Exception("DoctorUnavailabilityDB elements must have form: [ID, Date, Time]");
		}
	}

	/**
	 * Saves the calling DoctorUnavailabilityDB object to a text file
	 * 
	 * @throws Exception
	 */
	protected void saveDoctorUnavailabilityDB() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("doctorUnavailabilityDB.txt"))) {
			out.writeObject(this);
		} catch (Exception e) {
			throw new Exception("Not saved properly");
		}
	}

	/**
	 * Loads the DoctorUnavailabilityDB object from doctorUnavailabilityDB.txt
	 * 
	 * @return DoctorUnavailabilityDB object
	 * @throws Exception
	 */
	protected DoctorUnavailabilityDB loadDoctorUnavailabilityDB() throws Exception {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("doctorUnavailabilityDB.txt"))) {
			return (DoctorUnavailabilityDB) in.readObject();
		} catch (Exception e) {
			DoctorUnavailabilityDB.initDB();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("doctorUnavailabilityDB.txt"))) {
				return (DoctorUnavailabilityDB) in.readObject();
			} catch (Exception e1) {
				throw new Exception("Load unsuccessful");
			}
		}
	}

	/**
	 * Method initializes the doctor availability database to empty
	 * 
	 * @throws Exception
	 */
	protected static void initDB() throws Exception {
		DoctorUnavailabilityDB constructDB = new DoctorUnavailabilityDB();
		constructDB.saveDoctorUnavailabilityDB();
	}

} // end class DoctorUnavailabilityDB
