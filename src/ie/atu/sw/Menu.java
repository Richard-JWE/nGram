package ie.atu.sw;

import java.util.Scanner;

public class Menu {
	// Parser.parseDirectory() -->
								// BuildNGrams()
	public static Scanner input = new Scanner(System.in); // Scanner input
								public String directory; // SpecifyTextFileDirectory()-->
	public String outputFile; // SpecifyOutputFile()
	public int nGramSize = 0; //nGramSize

	public void BuildNGrams() throws Exception { // make the output file from
													// program
		if (outputFile != null && nGramSize > 0 && directory != null) { // if
																		// block
																		// to
																		// check
																		// if
																		// the
																		// values
																		// are
																		// not
																		// null
																		// and
																		// greater
																		// than
																		// 0
			Parser.parseFile(directory, nGramSize); // Calls Parser object and
													// parseFile method to parse
													// the directory and
													// nGramSize to a file
													// format
			Parser.save(outputFile, nGramSize); // Calls Parser object and save
												// method to save the outputFile
												// and
			System.out.println(directory + " --> Outputfile in CSV format --> "
					+ outputFile);
			menu();

		}
	}

	public void menu() throws Exception {
		while (true) { // show menu indefinitely as will always be true until
						// return/break
			showMenu();
			int op = input.nextInt(); // asks the user to enter a choice
			switch (op) { // The switch block to evaluate the value of op and
							// match it to case label
				case 1 -> SpecifyTextFileDirectory();
				case 2 -> SpecifyNGramSize();
				case 3 -> SpecifyOutputFile();
				case 4 -> BuildNGrams();
				case 5 -> Quit();
				default -> throw new AssertionError("Unknown op: " + op); // throw
																			// AssertionError
																			// if
																			// the
																			// option
																			// is
																			// not
																			// valid
			}
		}
	}

	private void Quit() { // Exit the program completely
		System.out.println("Quitting Program");
		System.exit(0);
	}

	/**
	 * Show menu prints the menu with options 1-5 in a CLI
	 */

	public final void showMenu() { // shows in CLI runs from Runner class
		System.out.println(ConsoleColour.WHITE);
		System.out.println(
				"************************************************************");
		System.out.println(
				"*      ATU - Dept. Computer Science & Applied Physics      *");
		System.out.println(
				"*                                                          *");
		System.out.println(
				"*                  N-Gram Frequency Builder                *");
		System.out.println(
				"*                                                          *");
		System.out.println(
				"************************************************************");

		System.out.println("(1) Specify Text File Directory");
		System.out.println("(2) Specify n-Gram Size");
		System.out.println("(3) Specify Output File");
		System.out.println("(4) Build n-Grams ");
		System.out.println("(5) Quit");
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
		System.out.print("Select Option [1-5]>");
		System.out.println();
	}

	public void SpecifyNGramSize() throws Exception {
		System.out.println("Please enter N-Gram Size:");
		nGramSize = input.nextInt(); // Asks the user to input the ngramSize
		if (nGramSize > 0) { // if the variable is greater than 0
			System.out.println("Success --> nGramSize: " + nGramSize); // print
																		// value
			menu();

		}
	}

	public void SpecifyOutputFile() throws Exception { // Asks user to enter
														// output file, set
														// value
		System.out.println("Please enter Output File Name:");
		outputFile = input.next(); // sets outputFile
		System.out.println("Success --> outputFile: " + outputFile); // print
																		// value
		System.out.println();
		menu();

	}
	public void SpecifyTextFileDirectory() throws Exception {
		System.out.println("Please Enter the File Path to the Text File :");
		directory = input.next(); // refers to this.directory
		System.out.println("Input File Location Selected --> " + directory); // print
																				// values
		System.out.println();
		menu();
	}
}
