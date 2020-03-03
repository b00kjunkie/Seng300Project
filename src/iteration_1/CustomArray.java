package iteration_1;

/**
 * The CustomArray.java class implements an Arraylist where each element is a String array. The 
 * length of each element is determined by the length of the array that is passed as a parameter
 * in the constructor or add() instance method.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-02
 */

import java.util.ArrayList;

public class CustomArray {
	ArrayList<CustomElement> customArray; // ArrayList is the main "container"

	/**
	 * Constructor for CustomArray. Parameter is a String array, which is considered
	 * to be the first element of the CustomArray.
	 * 
	 * @param arr - 1st element of CustomArray of type String[]
	 */
	public CustomArray(String[] arr) {
		customArray = new ArrayList<>();
		customArray.add(new CustomElement(arr));
	}

	/**
	 * Determine and return the size of the CustomArray object.
	 * 
	 * @return int representing number of elements in CustomArray
	 */
	public int size() {
		return customArray.size();
	}

	/**
	 * Getter for ith element of CustomArray object.
	 * 
	 * @param i - index of CustomArray
	 * @return the CustomElement corresponding to ith element of CustomArray
	 */
	public CustomElement get(int i) {
		return customArray.get(i);
	}

	/**
	 * Appends a CustomElement to CustomArray object.
	 * 
	 * @param arr - String[] used to implement a new CustomElement
	 */
	public void add(String[] arr) {
		customArray.add(new CustomElement(arr));
	}

	/**
	 * Removes and discards the ith element of CustomArray object.
	 * 
	 * @param i - index of CustomArray
	 */
	public void remove(int i) {
		customArray.remove(i);
	}

	public boolean containsKey(String username) {
		for (int i = 0; i < customArray.size(); i++) {
			if (customArray.get(i).getCustomElement()[0]
					.equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	// Note: Need a method that quickly/easily prints the contents of CustomArray object

} // end class CustomArray