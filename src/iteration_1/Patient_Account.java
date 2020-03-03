package iteration_1;

/*
 * Currently Patient account is a quick sample of future Account class which have three subclasses: 
 * Patient , Doctor , and Nurse.
 */
/**
 * @author boyang_dong
 *
 */

public class Patient_Account {

	// username and password variable ;
	private String patient_username;
	private String patient_password;

	// minmum number of letters for username
	private static int min_user_name = 6;
	private static int max_user_name = 25;

	// minmum number of letters for user password
	private static int min_user_pwd = 8;
	private static int max_user_pwd = 40;

	// if we need more complex check with password we can use regex
//	private static final String pattern = ".*[A-Z].*";

	// patient special ID; we can consider to be string if we want to use both
	// letter and number
	// ID will be currently random generated.
	private int patient_id;

	// patient age, name as part of record on file.
	private int patient_age;
	private String patient_name;

	// consider a max number of appointment per patient to start with. we can revise
	// later
	final int max_appointment = 10;

	// appointments variable is a string array contain name or content of the
	// appointment.
	// we can turn this into classes with more information on appointment given.
	private String[] appointments;

	public Patient_Account(String usrname, String passwrd) {

	}

	/*
	 * this method check User name is valid or not.
	 * 
	 * @param : string of user name created. currently simply set to with two rules:
	 * - length of a user name is with in the range .
	 */
	public static boolean checkUsername(String usrname) {

		boolean valid = true;

		if (usrname.length() <= min_user_name
				|| usrname.length() >= max_user_name) {

			valid = false;

		}

		return valid;

	}

	/*
	 * this method will check the password allowed under two conditions - min and
	 * max limit of length - at least one capital letter exist
	 */
	public static boolean checkPassword(String password) {

		boolean valid = true;

		String pwd = new String(password);

		if (pwd.length() <= min_user_pwd
				|| pwd.length() >= max_user_pwd) {

			valid = false;

		}

		else if (pwd.contentEquals(pwd.toLowerCase())) {

			valid = false;
		}

		return valid;
	}

	/*
	 * getter for user name
	 */

	protected String getUsername() {

		return patient_username;
	}

	/*
	 * set user name if it is valid
	 */
	protected boolean setUsername(String username) {

		if (Patient_Account.checkUsername(username)) {

			this.patient_username = username;
			return true;
		}
		return false;
	}

	/*
	 * getter for user password
	 */
	protected String getPassword() {

		return patient_password;

	}

	/*
	 * check if the password is valid.
	 * 
	 * @return : boolean true for valid, vice versa.
	 */
	protected boolean setPassword(String password) {

		if (Patient_Account.checkPassword(password)) {

			this.patient_password = password;

			return true;
		}

		return false;
	}

	/*
	 * getter for user password
	 */
	protected String getPatientName() {

		return patient_name;

	}

	/*
	 * set patient new name
	 */
	protected void setPatientName(String newName) {

		this.patient_name = new String(newName);

	}

}
