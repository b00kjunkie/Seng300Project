package iteration_1;

import java.util.*;


public class Patient_Auth {
	
	
		private HashMap<String,Patient_Account> patients;
		
		

		public Patient_Auth(HashMap<String, Patient_Account> patients) {
			
			this.patients = patients;
		}
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
		
		
		
	    public boolean checkPassword(char[] password) {
			
			return Patient_Account.checkPassword(password);
			
		}
		
	    /*
	     * if user did not check username or password before move on to personal information form,
	     * this method will still capture the same message if the username or password is invalid.
	     */
		public String register(String username, char[] password) {
			
			boolean correctuser = Patient_Account.checkUsername(username);
			boolean correctpass = Patient_Account.checkPassword(password);
			boolean notsameuser = !patients.containsKey(username);
			if(correctuser && correctpass && notsameuser) {
				
				
				return "Successfully created new user !" + "\n" + "Please continue finish your perosnal information!";
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
		
		
		/**
		 * add new patients
		 * @param account
		 */
		public void addPatient(Patient_Account account) {
			
			this.patients.put(account.getUsername(),account);
		}
		
		/**
		 * 
		 * @param username
		 * @param password
		 * @return
		 */
		public Patient_Account login(String username, char[] password) {
			
			Patient_Account oldPatient;
			String pwd = new String(password);
			
			if(patients.containsKey(username)) {
				
				oldPatient = patients.get(username);
				
				
				System.out.println("username is found in the system.");
				
				
				if(pwd.contentEquals(new String(patients.get(username).getPassword()))) {
					
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

