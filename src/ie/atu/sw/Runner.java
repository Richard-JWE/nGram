package ie.atu.sw;

/**
 *
 * @author Richard Jameson
 */

public class Runner {

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) throws Exception {
		try {
			Menu m = new Menu(); // create object Menu named m
			m.menu(); // access the Menu object and call m
		} catch (Exception e) { // catch block
			System.out.println("ERROR: Apllication Crashed"); // error message
			e.printStackTrace(); // print error stack trace
		}
	}
}