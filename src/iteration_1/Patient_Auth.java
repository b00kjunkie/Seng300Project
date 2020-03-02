package iteration_1;

import java.util.HashMap;


public class Patient_Auth {
	
	
		private HashMap<String,Patient_Account> patients = new HashMap<String,Patient_Account>();
		
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
		
		
		
	    public boolean checkPassword(String password) {
			
			return Patient_Account.checkPassword(password);
			
		}
		
	    /*
	     * if user did not check username or password before move on to personal information form,
	     * this method will still capture the same message if the username or password is invalid.
	     */
		public String register(String username, String password) {
			
			boolean correctuser = Patient_Account.checkUsername(username);
			boolean correctpass = Patient_Account.checkPassword(password);
			boolean notsameuser = !patients.containsKey(username);
			if(correctuser && correctpass && notsameuser) {
				
				patients.put(username, new Patient_Account(username, password));
				
				return "Successfully created new user !" + "\n" + "Welcome to Alberta Hospital System";
			}
			if(!correctuser) {
				return "Sorry, this username is not valid.";
			}
			if(!correctpass) {
				return "Sorry, this password is not valid.";
			}
			if(!notsameuser) {
				return "This username has already been taken.";
			}
			return "Unexpected System Error"; 
		}
		
		public Patient_Account login(String username, String password) {
			
			Patient_Account oldPatient;
			
			if(patients.containsKey(username)) {
				
				oldPatient = patients.get(username);
				
				
				System.out.println("username is found in the system.");
				
				
				if(patients.get(username).getPassword().equals(password)) {
					
					System.out.println("Welcome back "+ oldPatient.getPatientName());
					
					return oldPatient;
				}
				else {
					
					System.out.println("Password does not match.");
					
					return null;
				}
			}
			else {
				
				return null;
			}
		}

	}

