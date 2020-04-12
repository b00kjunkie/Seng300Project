package iteration_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomElementTest {

	/**
	 * Generates two string arrays and uses the first of them to create a CustomElement.
	 * It then uses JUnit asserts to check that the CustomElement equals the first
	 * object and not the second.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomElement() {
		String[] arg = new String[1];
		arg[0] = "var1";
		String[] arg2 = new String[1];
		arg2[0] = "var2";
		
		CustomElement test = new CustomElement(arg);
		assertEquals(test.element,arg);
		assertNotEquals(test.element,arg2);
		
	}
	
	/**
	 * Generates two string arrays and uses the first of them to create a CustomElement.
	 * It then uses JUnit asserts to check that the getCustomElement returns
	 * the first string array and not the second.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testgetCustomElement() {
		String[] arg = new String[1];
		arg[0] = "var1";
		String[] arg2 = new String[1];
		arg2[0] = "var2";
		
		CustomElement test = new CustomElement(arg);
		assertEquals(test.getCustomElement(),arg);
		assertNotEquals(test.getCustomElement(),arg2);
	}

	/**
	 * Generates two string arrays and uses the first of them to create a CustomElement.
	 * It then uses JUnit asserts to check that setCustomElement changes
	 * the value of the CustomElement.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testsetCustomElement() {
		String[] arg1 = new String[1];
		arg1[0] = "var1";
		
		String[] arg2 = new String[1];
		arg2[0] = "var2";
		
		CustomElement test = new CustomElement(arg1);
		test.setCustomElement(arg2);
		
		assertEquals(test.getCustomElement(),arg2);
		assertNotEquals(test.getCustomElement(),arg1);
	}
}
