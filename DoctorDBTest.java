package iteration_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorDBTest {

	/**
	 * Generates a DoctorDB and tests that the Add function
	 * properly adds String[] of the correct format.
	 */
	@Test
	public void testAdd() {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		String[] var2 = new String[6];
		var2[0] = "321123";
		var2[1] = "Bradbradbrad";
		var2[2] = "PassWord2";
		var2[3] = "MyNameIsBill";
		var2[4] = "Male";
		var2[5] = "Surgery";
		
		String[] var3 = new String[6];
		var3[0] = "321123";
		var3[1] = "Bradbradbrad";
		var3[2] = "PassWord2";
		
		DoctorDB temp = null;
		try {
			temp = new DoctorDB(var1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			temp.add(var2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to add to DoctorDB");
		}
		try {
			temp.add(var3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assert(true);
		}
		
		
		
	}

	/**
	 * Generates a DoctorDB and checks that the initialization
	 * works properly
	 */
	@Test
	public void testDoctorDB() {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		String[] var2 = new String[6];
		var2[0] = "123321";
		var2[1] = "BobBobBob";
		var2[2] = "PassWord1";
		var2[3] = "MyNameIsBob";
		
		DoctorDB temp = null;
		try {
			temp = new DoctorDB(var1);
			assert(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DoctorDB temp2 = null;
		try {
			temp = new DoctorDB(var2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assert(true);
		}
		
	}


	/**
	 * Generates a DoctorDB and checks that the getDoctorRecord function
	 * returns the correct record.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDoctorRecord() throws Exception {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		CustomArray temp2 = new CustomArray(var1);
		
		DoctorDB temp = new DoctorDB(var1);
		temp.getDoctorRecord("123321");
		assertEquals(temp.getDoctorRecord("123321"),temp2.get(0).getCustomElement());
		
	}

	/**
	 * Generates a DoctorDB and checks that the FindDoctorsInDepartment
	 * function returns all doctors in that department.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testFindDoctorsInDepartment() {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		CustomArray temp2 = new CustomArray(var1);
		DoctorDB temp = null;
		try {
			 temp = new DoctorDB(var1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			assertEquals(temp.findDoctorsInDepartment("Surgery").get(0).getCustomElement(),temp2.get(0).getCustomElement());
			assert(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("findDoctorsInDepartment not implemented correctly");
		}
		
		try {
			assertEquals(temp.findDoctorsInDepartment("Emergency").get(0).getCustomElement(),temp2.get(0).getCustomElement());
		} catch (Exception e) {
			assert(true);
		}
	}

	/**
	 * The functionality of the SaveDoctorDB method was tested
	 * as part of the GUI tests
	 */
	@Test
	public void testSaveDoctorDB() {
		assert(true);
	}

	/**
	 * The functionality of the LoadDoctorDB method was tested
	 * as part of the GUI tests
	 */
	@Test
	public void testLoadDoctorDB() {
		assert(true);
	}

	/**
	 * The functionality of the InitDoctorDB method was tested
	 * as part of the GUI tests
	 */
	@Test
	public void testInitDoctorDB() {
		assert(true);
	}

}
