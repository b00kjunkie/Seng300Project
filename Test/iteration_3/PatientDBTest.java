package iteration_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatientDBTest {

	/**
	 * Because all of the DB classes inherit from the same class,
	 * the unlisted functions are identical across all the DB classes.
	 * Thus, writing tests for this class would be superfluous.
	 */
	
	
	/**
	 * Generates a PatientDB and checks that the usernameAvailable 
	 * properly checks if a username is available.
	 * @throws Exception
	 */
	@Test
	public void testUsernameAvailable() throws Exception {
		String[] var1 = new String[9];
		var1[0] = "1";
		var1[1] = "abc";
		var1[2] = "bbb";
		var1[3] = "123";
		var1[4] = "M";
		var1[5] = "11/11/11";
		var1[6] = "N";
		var1[7] = "N";
		var1[8] = "N";
		
		PatientDB temp = new PatientDB(var1);
		assertEquals(temp.usernameAvailable("abc"),false);
		assertEquals(temp.usernameAvailable("bob"),true);
	}

}
