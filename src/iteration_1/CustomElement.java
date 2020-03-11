package iteration_1;

/**
 * CustomElement.java class is a helper class for CustomArray class.
 * Implements the elements of a CustomArray object in the form of String arrays.
 * 
 * @author 		SENG 300 Group 12 - Winter 2020
 * Date: 		2020-03-02
 */

import java.io.Serializable;

final class CustomElement implements Serializable { // implement serializable

	private static final long serialVersionUID = 2L; // serial ID for java object saving
	protected String[] element; // "container" for each element of the CustomArray

	/**
	 * Constructor used to implement an arbitrary size element as a String array.
	 * 
	 * @param arr - String array that defines new instance of CustomElement
	 */
	protected CustomElement(String[] arr) {
		element = arr;
	}

	/**
	 * Getter returns the String array of the CustomElement object
	 * 
	 * @return String[]
	 */
	protected String[] getCustomElement() {
		return element;
	}

	/**
	 * Setter assigns the String array parameter to CustomElement object
	 * 
	 * @param newElement
	 */
	protected void setCustomElement(String[] newElement) {
		element = newElement;
	}

} // end class CustomElement

