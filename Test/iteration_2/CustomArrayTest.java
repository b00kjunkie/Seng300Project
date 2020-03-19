package iteration_1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import iteration_1.CustomElement;

public class CustomArrayTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testCustomArray() {
		String[] arg = new String[1];
		arg[0] = "val1";
		
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.get(0).getCustomElement(),new CustomElement(arg).getCustomElement());
	}

	@Test
	public void testSize() {
		String[] arg = new String[1];
		arg[0] = "val1";
		
		CustomArray test = new CustomArray(arg);
		int size_output = test.size();
		
		assertEquals(size_output,1);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGet() {
		String[] arg = new String[1];
		arg[0] = "This is a test";
		
		CustomElement temp = new CustomElement(arg);
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.get(0).getCustomElement(), temp.getCustomElement());
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		
		assertEquals(test.get(1).getCustomElement(),new CustomElement(arg2).getCustomElement());
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRemove() {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		test.remove(0);
		
		assertEquals(test.get(0).getCustomElement(),new CustomElement(arg2).getCustomElement());
	}

	@Test
	public void testContainsKey() {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		
		assertEquals(test.containsKey("This is also a test"),true);
		assertEquals(test.containsKey("NOPE"),false);
		
		
	}

}
