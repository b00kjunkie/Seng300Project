package iteration_2;

/**
 * The CustomArray.java class implements an Arraylist where each element is a String array. The 
 * length of each element is determined by the length of the array that is passed as a parameter
 * in the constructor or add() instance method.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-02
 * Updated:		2020-03-10
 */

import java.io.Serializable;
import java.util.ArrayList;

public class CustomArray implements Serializable { // implement serializable so objects can be saved

	private static final long serialVersionUID = 1L; // serial ID for java object saving

	ArrayList<CustomElement> customArray; // ArrayList is the main "container"

	/**
	 * Default constructor creates a new ArrayList and assigns customArray as reference variable
	 * 
	 * @throws Exception
	 */
	protected CustomArray() throws Exception {
		customArray = new ArrayList<>();
	}

	/**
	 * Constructor for CustomArray. Parameter is a String array, which is considered to be the first element of the
	 * CustomArray.
	 * 
	 * @param arr - 1st element of CustomArray of type String[]
	 */
	protected CustomArray(String[] arr) {
		customArray = new ArrayList<>();
		customArray.add(new CustomElement(arr));
	}

	/**
	 * Determine and return the size of the CustomArray object.
	 * 
	 * @return int representing number of elements in CustomArray
	 */
	protected int size() {
		return customArray.size();
	}

	/**
	 * Getter for ith element of CustomArray object.
	 * 
	 * @param i - index of CustomArray
	 * @return the CustomElement corresponding to ith element of CustomArray
	 */
	protected CustomElement get(int i) {
		return customArray.get(i);
	}

	/**
	 * Appends a CustomElement to CustomArray object.
	 * 
	 * @param arr - String[] used to implement a new CustomElement
	 * @throws Exception
	 */
	protected void add(String[] arr) throws Exception {
		customArray.add(new CustomElement(arr));
	}

	/**
	 * Removes and discards the ith element of CustomArray object.
	 * 
	 * @param i - index of CustomArray
	 */
	protected void remove(int i) {
		customArray.remove(i);
	}

	/**
	 * Change where this is used to patientDB.search(username, 1).isEmpty()
	 * 
	 * @param username
	 * @return
	 */
	protected boolean containsKey(String username) {
		for (int i = 0; i < customArray.size(); i++) {
			if (customArray.get(i).getCustomElement()[0].equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method looks at every CustomElement (row) in the calling database and determines if the str parameter equals the
	 * element in position pos. If they are equal, ignoring case, then the CustomElement is added to the return
	 * CustomArray. Any and all matches will be returned.
	 * 
	 * @param str - String to be matched
	 * @param pos - position to match
	 * @return CustomArray containing CustomElements whose pos element equals str
	 * @throws Exception
	 */
	protected CustomArray search(String str, int pos) throws Exception {

		CustomArray custArr = new CustomArray();

		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getCustomElement()[pos].equalsIgnoreCase(str)) {
				custArr.add(this.get(i).getCustomElement());
			}
		}
		return custArr;
	}

	/**
	 * Prints contents of each of the CustomElement objects within a CustomArray to the console. Used primarily as a
	 * reference and not intended to be used in the final product of the software.
	 */
	protected void printArray() {

		if (customArray.size() == 0) {
			System.out.println("Empty");
		}

		for (int i = 0; i < customArray.size(); i++) {
			for (int j = 0; j < customArray.get(i).getCustomElement().length; j++) {
				System.out.print(customArray.get(i).getCustomElement()[j] + " ");
			}
			System.out.println();
		}
		System.out.println("*********************");
	}

	/**
	 * Method checks if the calling CustomArray object has any CustomElements.
	 * 
	 * @return boolean result
	 */
	protected boolean isEmpty() {
		return this.customArray.size() == 0;
	}

} // end class CustomArray