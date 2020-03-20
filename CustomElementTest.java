package iteration_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomElementTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testCustomElement() {
		String[] arg = new String[1];
		arg[0] = "var1";
		
		CustomElement test = new CustomElement(arg);
		assertEquals(test.element,arg);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetCustomElement() {
		String[] arg = new String[1];
		arg[0] = "var1";
		
		CustomElement test = new CustomElement(arg);
		assertEquals(test.getCustomElement(),arg);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testsetCustomElement() {
		String[] arg1 = new String[1];
		arg1[0] = "var1";
		
		String[] arg2 = new String[1];
		arg2[0] = "var1";
		
		CustomElement test = new CustomElement(arg1);
		test.setCustomElement(arg2);
		
		assertEquals(test.getCustomElement(),arg2);
	}
}
