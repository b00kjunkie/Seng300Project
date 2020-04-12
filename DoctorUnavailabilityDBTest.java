package iteration_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorUnavailabilityDBTest {

	/**
	 * Because all of the DB classes inherit from the same class,
	 * the unlisted functions are identical across all the DB classes.
	 * Thus, writing tests for this class would be superfluous.
	 */
	
	/**
	 * Generates a DoctorUnavailabilityDB and checks that the removeMatchStartEndID
	 * function correctly removes unavailability times.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testRemoveMatchStartEndID() throws Exception {
		String[] var1 = new String[5];
		var1[0] = "1";
		var1[1] = "2";
		var1[2] = "11/11/2020";
		var1[3] = "3";
		var1[4] = "4";
		
		String[] var2 = new String[5];
		var2[0] = "5";
		var2[1] = "6";
		var2[2] = "11/12/2020";
		var2[3] = "7";
		var2[4] = "8";
		
		
		DoctorUnavailabilityDB temp = new DoctorUnavailabilityDB();
		temp.add(var1);
		temp.add(var2);
		

		temp.removeMatchStartEndID("2","11/11/2020","3","4");
		assertEquals(temp.get(0).getCustomElement(),new CustomElement(var2).getCustomElement());

		
	}

}
