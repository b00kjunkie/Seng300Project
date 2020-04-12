package iteration_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomArrayTest {

	/**
	 * Generates a CustomArray of two values and checks that they are 
	 * properly stored in the CustomArray.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomArray() {
		String[] arg = new String[1];
		arg[0] = "val1";
		String[] arg2 = new String[1];
		arg[0] = "val2";
		
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.get(0).getCustomElement(),new CustomElement(arg).getCustomElement());
		assertNotEquals(test.get(0).getCustomElement(),new CustomElement(arg2).getCustomElement());
	}

	/**
	 * Generates a CustomArray and checks that the size function
	 * returns the correct value.
	 */
	@Test
	public void testSize() {
		String[] arg = new String[1];
		arg[0] = "val1";
		
		CustomArray test = new CustomArray(arg);
		int size_output = test.size();
		
		assertEquals(size_output,1);
		assertNotEquals(size_output,2);
	}

	/**
	 * Generates a CustomArray and checks that the get function
	 * returns the correct value
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGet() {
		String[] arg = new String[1];
		arg[0] = "This is a test";
		
		CustomElement temp = new CustomElement(arg);
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.get(0).getCustomElement(), temp.getCustomElement());
		
	}

	/**
	 * Generates a custom array and checks that the getID function
	 * returns the correct value.
	 * @throws Exception
	 */
	@Test
	public void testGetID() throws Exception {
		String[] arg = new String[5];
		arg[0] = "1";
		arg[1] = "NB";
		arg[2] = "123";
		arg[3] = "N";
		arg[4] = "M";
		
		CustomArray test = new CustomArray(arg);
		assertEquals(test.getID("NB","123"),"1");
		assertNotEquals(test.getID("NB","123"),"2");
		
	}

	/**
	 * Generates a CustomArray and checks that the add function
	 * correctly adds CustomElements to the CustomArray.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() throws Exception {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		
		assertEquals(test.get(1).getCustomElement(),new CustomElement(arg2).getCustomElement());
		
	}

	/**
	 * Generates a CustomArray and tests that the remove function
	 * properly removes CustomElements from the CustomArray.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testRemove() throws Exception {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		test.remove(0);
		
		assertEquals(test.get(0).getCustomElement(),new CustomElement(arg2).getCustomElement());
	}


	/**
	 * Generates a CustomArray and checks that the matchNameToID function
	 * properly matches names to IDs.
	 * @throws Exception
	 */
	@Test
	public void testMatchNameToID() throws Exception {
		String[] arg = new String[5];
		arg[0] = "1";
		arg[1] = "NB";
		arg[2] = "123";
		arg[3] = "N";
		arg[4] = "M";
		
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.matchNameToID("N"),"1");
		assertNotEquals(test.matchNameToID("N"),"2");
	}

	/**
	 * Generates a CustomArray and checks that the checkForMatch
	 * properly searches for matches in the array.
	 * @throws Exception
	 */
	@Test
	public void testCheckForMatch() throws Exception {
		String[] arg = new String[5];
		arg[0] = "1";
		arg[1] = "NB";
		arg[2] = "123";
		arg[3] = "N";
		arg[4] = "M";
		
		CustomArray test = new CustomArray(arg);
		
		assertEquals(test.checkForMatch("NB","123"),true);
		assertNotEquals(test.checkForMatch("NB","123"),false);
		assertEquals(test.checkForMatch("AB","143"),false);
		
	}

	/**
	 * Generates a CustomArray and tests the search function.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testSearch() throws Exception {
		String[] arg1 = new String[1];
		arg1[0] = "This is a test";
		
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg1);
		test.add(arg2);
		
		assertEquals(test.search("This is a test",0).get(0).getCustomElement(),test.get(0).getCustomElement());
		assertNotEquals(test.search("This is also a test",0).get(0).getCustomElement(),test.get(0).getCustomElement());
	}

	/**
	 * Generates two CustomArrays and checks that the IsEmpty function
	 * works properly.
	 * @throws Exception
	 */
	@Test
	public void testIsEmpty() throws Exception {
		String[] arg2 = new String[1];
		arg2[0] = "This is also a test";
		
		CustomArray test = new CustomArray(arg2);
		CustomArray test2 = new CustomArray();
		assertEquals(test.isEmpty(),false);
		assertEquals(test2.isEmpty(),true);
	}

}
