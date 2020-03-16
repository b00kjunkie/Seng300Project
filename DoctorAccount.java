package iteration2;

public class DoctorAccount {
	
	private String username;
	
	private String password;
	
	public static boolean checkUsername(String username) {
		if(username.length() <= 16) {
			return true;
		}
		return false;
	}

	public static boolean checkPassword(String pass) {
		if(pass.length() >= 16) {
			return true;
		}
		return false;
	}

	public DoctorAccount(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	protected String getUsername() {
		return username;
	}

	protected boolean setUsername(String username) {
		if(DoctorAccount.checkUsername(username)) {
			this.username = username;
			return true;
		}
		return false;
		
	}
		
	protected String getPassword() {
		return password;
	}

	protected boolean setPassword(String password) {
		if(DoctorAccount.checkPassword(password)) {
			this.password = password;
			return true;
		}
		return false;
	}
	
	
}
