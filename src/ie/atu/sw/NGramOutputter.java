package ie.atu.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The text to be outputted to a file and the table to be extended to store
 * output in file and formated correctly
 */

public class NGramOutputter {
	public static Object[][] table2D = new Object[1000][2]; // Use a 2D array
															// to store the
															// frequency and
															// N-Gram
															// Size
	public static int index;
	public static void save(Object[][] table2D, String outputFile, int nGSize) // Outputs
																				// the
																				// table
																				// to
																				// a
																				// file

			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(outputFile)); // Uses Print
																// Writer to
																// print
																// formatted
																// representations
																// of objects to
																// a text
																// outputFile
		String line = System.getProperty("line.separator");

		pw.print(nGSize + "-Gram" + "," + "Counter");
		pw.println();

		for (Object[] element : table2D) { // loop through the
											// rows in the
											// table2D
			pw.write(element[0] + "," + element[1] + line); // write
															// the
															// table
															// with
															// 2
															// rows
		}

		pw.close(); // close the pw to prevent memory leak
	}
	public static void save(String outputFile, int nGSize)
			throws FileNotFoundException {
		save(table2D, outputFile, nGSize); // Calls the save method and
											// overloads save to accept the
											// Accepted arguments
	}
	public String outputFile;

	public String directory;

	public int nGSize;

	public Object[][] expandTable(Object[][] previous) { // extend object table
															// to use
		int prevRowc = previous.length;
		Object[][] extraRows = new Object[prevRowc + 50][]; // 50
		System.arraycopy(previous, 1, extraRows, 0, previous.length); // copy
																		// into
																		// columns
		return extraRows; // extra rows added
	}

	public int getIndex() { // get index
		return index;
	}

	public void Parser(int nGSize, String outputFile, String directory) { // assign
																			// getter
																			// and
																			// setter
																			// values

		this.directory = directory;
		this.nGSize = nGSize;
		this.outputFile = outputFile;
	}
}