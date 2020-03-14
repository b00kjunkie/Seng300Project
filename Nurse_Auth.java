package iteration_2;

import java.util.ArrayList;
import java.util.HashMap;


public class Nurse_Auth {
	
	private HashMap<String, Nurse_Account> accounts = new HashMap<String, Nurse_Account>();

	/**
	 * 
	 */
	public Nurse_Auth() {
		// TODO Auto-generated constructor stub
	}
	
	public String register(String username, String password) {
		boolean correctuser = Nurse_Account.checkUsername(username);
		boolean correctpass = Nurse_Account.checkPassword(password);
		boolean notsameuser = !accounts.containsKey(username);
		if(correctuser && correctpass && notsameuser) {
			accounts.put(username, new Nurse_Account(username, password));
			return "Works";
		}
		if(!correctuser) {
			return "Invalid username";
		}
		if(!correctpass) {
			return "Invalid password";
		}
		if(!notsameuser) {
			return "Username taken";
		}
		return "Unknown issue"; 
	}
	
	public Nurse_Account login(String username, String password) {
		if(accounts.containsKey(username)) {
			if(accounts.get(username).getPassword().equals(password)) {
				return accounts.get(username);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
}
