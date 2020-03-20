package iteration_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorDBTest {

	@Test
	public void testGetID() throws Exception {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		DoctorDB temp = new DoctorDB(var1);
		
		assertEquals(temp.getID("BobBobBob", "PassWord1"),"123321");
	}

	@Test
	public void testCheckForMatch() throws Exception {
		String[] var1 = new String[6];
		var1[0] = "123321";
		var1[1] = "BobBobBob";
		var1[2] = "PassWord1";
		var1[3] = "MyNameIsBob";
		var1[4] = "Male";
		var1[5] = "Surgery";
		
		DoctorDB temp = new DoctorDB(var1);
		assertEquals(temp.checkForMatch("BobBobBob","PassWord1"),true);
		assertEquals(temp.checkForMatch("nonononon","thingblahh"),false);
		
	}
	
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
}
