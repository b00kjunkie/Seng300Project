package iteration_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Patient_AuthTest {

	@Test
	public void testCheckUsername() {
		Patient_Auth test = new Patient_Auth();
		assertEquals(test.checkUsername("test"),false);
		assertEquals(test.checkUsername("testtest"),true);
	}

	@Test
	public void testCheckSameUser() {
		Patient_Auth test = new Patient_Auth();
		assertEquals(test.checkSameUser("test"),false);
		assertEquals(test.checkSameUser("Ken"),true);
	}

	@Test
	public void testCheckPassword() {
		Patient_Auth test = new Patient_Auth();
		assertEquals(test.checkPassword("test"),false);
		assertEquals(test.checkPassword("testasdfasdf"),false);
		assertEquals(test.checkPassword("tesFAttest"),true);
	}

	@Test
	public void testRegister() {
		Patient_Auth test = new Patient_Auth();
		assertEquals(test.register("Kenasdfasdf", "123asdfFFF"),"Successfully created new user !" + "\n"
				+ "Welcome to Alberta Hospital System");
		assertEquals(test.register("Kenasdfasdf", "FFFFFFFFFF"),"This username has already been taken.");
		assertEquals(test.register("asdffdsaasd", "1aaaa"),"Sorry, this password is not valid.");
		assertEquals(test.register("asdd", "1afFFFFaaa"),"Sorry, this username is not valid.");
	
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testLogin() {
		Patient_Auth test = new Patient_Auth();
		assertEquals(test.login("Ken", "123").getCustomElement(),new CustomArray(new String[]{"Ken", "123"}).get(0).getCustomElement());
	}

}
