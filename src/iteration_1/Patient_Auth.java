package iteration_1;

public class Patient_Auth {

	// pretend we are saving/loading this CustomArray object, so that there is
	// already one username+password in the system
	private CustomArray patients = new CustomArray(new String[]{"Ken", "123"});

	/*
	 * Only check username is valid or not for quick checking for user here.
	 */
	public boolean checkUsername(String username) {
		return Patient_Account.checkUsername(username);
	}
	
	/*
	 * Only check username already is token or not
	 */
	public boolean checkSameUser(String username) {
		return patients.containsKey(username);
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPassword(String password) {
		return Patient_Account.checkPassword(password);
	}

	/*
	 * if user did not check username or password before move on to personal
	 * information form, this method will still capture the same message if the
	 * username or password is invalid.
	 */
	public String register(String username, String password) {

		boolean correctuser = Patient_Account.checkUsername(username);
		boolean correctpass = Patient_Account.checkPassword(password);
		boolean notsameuser = !patients.containsKey(username);
		if (correctuser && correctpass && notsameuser) {

			patients.add(new String[]{username, password});

			return "Successfully created new user !" + "\n"
					+ "Welcome to Alberta Hospital System";
		}
		if (!correctuser) {
			return "Sorry, this username is not valid.";
		}
		if (!correctpass) {
			return "Sorry, this password is not valid.";
		}
		if (!notsameuser) {
			return "This username has already been taken.";
		}
		return "Unexpected System Error";
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public CustomElement login(String username, String password) {

		CustomElement oldPatient;

		for (int i = 0; i < patients.size(); i++) {
			if (patients.get(i).getCustomElement()[0].equalsIgnoreCase(username)) {

				System.out.println("username is found in the system.");
				
				if (patients.get(i).getCustomElement()[1].equalsIgnoreCase(password)) {
					
					oldPatient = patients.get(i);
					System.out.println("Welcome back " + patients.get(i).getCustomElement()[0]);
					return oldPatient;
					
				} else {
					
					System.out.println("Password does not match.");
					return null;
				
				} // end inner if-else

			} // end outer if
			
		} // end for loop

		return null;

	} // end login

} // end class Patient_Auth
