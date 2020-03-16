package iteration2;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorAuth {
	
	private HashMap<String, DoctorAccount> accounts = new HashMap<String, DoctorAccount>();
	
	public DoctorAuth() {
		
	}
	
	public String register(String username, String password) {
		boolean correctuser = DoctorAccount.checkUsername(username);
		boolean correctpass = DoctorAccount.checkPassword(password);
		boolean notsameuser = !accounts.containsKey(username);
		if(correctuser && correctpass && notsameuser) {
			accounts.put(username, new DoctorAccount(username, password));
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
	
	public DoctorAccount login(String username, String password) {
		if(accounts.containsKey(username)) {
			System.out.println("found users");
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


