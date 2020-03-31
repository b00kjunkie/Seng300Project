package iteration_3;

/**
 * The AppointmentDB.java class is a subclass of the CustomArray class. It is intended to represent a database which
 * stores all the appointments in the system. Requested and scheduled appointments are indicated using flag. Current
 * data fields include: patient ID, doctor ID, department, date, start time, end time, and status.
 * 
 * @author SENG 300 Group 12 - Winter 2020 
 * Date: 2020-03-29
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppointmentDB extends CustomArray {

	private static final long serialVersionUID = 12L; // serial ID for java object saving

	/**
	 * Constructor with no parameters calls the super class constructor with no parameters.
	 * 
	 * @throws Exception
	 */
	protected AppointmentDB() throws Exception {
		super();
	}

	/**
	 * Constructor with string array parameter calls super class constructor, however, a check is performed to verify
	 * that the appointment record (CustomElement) passed has length 7, so that each appointment record has same form.
	 * 
	 * @param arr - type String[] of length 7 representing the appointment record
	 * @throws Exception
	 */
	protected AppointmentDB(String[] arr) throws Exception {
		super(arr);
		if (arr.length != 7) {
			throw new Exception(
					"AppointmentDB elements must have form: [Patient ID, Doctor ID, Department, Date, Start time, End time, Status] ");
		}
	}

	/**
	 * Method adds an appointment record (CustomElement) to the appointment database. Verifies that passed record has
	 * length 7.
	 */
	protected void add(String[] arr) throws Exception {
		if (arr.length == 7) {
			super.add(arr);
		} else {
			throw new Exception(
					"AppointmentDB elements must have form: [Patient ID, Doctor ID, Department, Date, Start time, End time, Status] ");
		}
	}

	/**
	 * Saves the calling ApppointmentDB object to a text file
	 * 
	 * @throws Exception
	 */
	protected void saveAppointmentDB() throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("appointmentDB.txt"))) {
			out.writeObject(this);
		} catch (Exception e) {
			throw new Exception("Not saved properly");
		}
	}

	/**
	 * Loads a AppointmentDB object from a text file. If method cannot successfully load appointmentDB.txt, then the
	 * database is reinitialized using the reinitDB() method.
	 * 
	 * @return AppointmentDB object
	 * @throws Exception
	 */
	protected AppointmentDB loadAppointmentDB() throws Exception {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("appointmentDB.txt"))) {
			return (AppointmentDB) in.readObject();
		} catch (Exception e) {
			this.saveAppointmentDB();
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("appointmentDB.txt"))) {
				return (AppointmentDB) in.readObject();
			} catch (Exception e1) {
				throw new Exception("Load unsuccessful");
			}
		}
	}

} // end class AppointmentDB
