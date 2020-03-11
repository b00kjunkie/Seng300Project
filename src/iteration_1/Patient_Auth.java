/**
 * This Class is not currently used in Ken's implementation
 */

package iteration_1;


public class Patient_Auth {
	
		// change to private and add getter
		public CustomArray patientDB = new CustomArray(new String[]{"Ken", "123"});
		
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
			
			return true;
			//return patients.containsKey(username);
		}
		
		
		
	    public boolean checkPassword(String password) {
			
			return Patient_Account.checkPassword(password);
			
		}
		
	    /*
	     * if user did not check username or password before move on to personal information form,
	     * this method will still capture the same message if the username or password is invalid.
	     */
		public String register(String username, String password) throws Exception {
			
			boolean correctuser = Patient_Account.checkUsername(username);
			boolean correctpass = Patient_Account.checkPassword(password);
			boolean notsameuser = !patientDB.containsKey(username);
			if(correctuser && correctpass && notsameuser) {
				
				patientDB.add(new String[]{username, password});
				
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

	}

