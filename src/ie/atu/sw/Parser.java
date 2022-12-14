package ie.atu.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileSystems;

/**
 * Text files processed and frequency computed for each n-gram selected
 */
public class Parser {
	public static int index;
	// private static Object[][] table2D;
	public static Object[][] table2D = new Object[1000][2];
	/**
	 * @param ngram
	 */
	public static void addNGram(String ngram) { // mapping of unique ngrams
		try {
			index = ngram.hashCode() % table2D.length; // HashCode to save items
														// in a key indexed
														// table and compute
														// array index from key
														// Divide HashCode by
														// table2D length -1

			long frequency = 1;

			if (table2D[index][1] != null) { // checks if the table at index 1
												// is not null
				frequency += (Long) table2D[index][1]; // type cast table2D at
														// index 1 to use with
														// the long counter
			}
			table2D[index][0] = ngram; // ngram column
			table2D[index][1] = frequency; // counter column

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param word
	 * @param nGSize
	 */
	public static void getNGrams(String word, int nGSize) { // search and
															// minus ngram size
															// to get ngrams

		String[] ngrams = new String[word.length() - nGSize + 1];

		for (int i = 0; i <= word.length() - nGSize; i++) { // for loop to
															// search each word
															// and minus the
															// nGSize
			ngrams[i] = word.substring(i, i + nGSize); // make a substring with
														// ngrams at i with the
														// arguments i, i +
														// nGSize
		}
		for (String t : ngrams) {
			addNGram(t);

		}
	}
	/**
	 * @param file
	 * @param ngSize
	 */
	public static void parseFile(String file, int ngSize) {
		try { // try with exceptions
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(file))); // buffers
																		// the
																		// characters
																		// to
																		// read
																		// input
																		// bytes
																		// convert
																		// bytes
																		// to
																		// buffer
																		// string

			String str; // Initialise str variable (standard)

			while ((str = br.readLine()) != null) { // to proceed the variable
													// str takes in the
													// input from br and
													// asks if str is still
													// null at the eof
				String[] words = str.split("\\s+");// splits the string into
													// matches on space
				for (String word : words) { // compares values
					word = word.trim().replaceAll("[^a-zA-Z]", "") // delimit
																	// the
																	// values by
																	// a comma
							.toLowerCase(); // convert the ngram word to lower
											// case
					if (word.length() >= ngSize) { // if the length of word is
													// greater than or equal the
													// ngSize then
													// call the getNGrams method
						getNGrams(word, ngSize);
					} else
						continue;
				}
			}
			br.close(); // if any issues close br, no memory leak
		} catch (Exception e) {
			System.out.println("ERROR: Failed To Parse File");
			e.printStackTrace(); // throwable stacktrace
			return;
		}

	}

	/**
	 * @param table2D
	 * @param outputFile
	 * @param ngSize
	 * @throws FileNotFoundException
	 */

	public static void save(Object[][] table2D, String outputFile, int ngSize)
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(outputFile));// Prints
																// formatted
																// representations
		String newLine = System.getProperty("line.separator"); // system
																// property
																// indicated by
																// the specified
																// key

		pw.print(ngSize + "-Gram" + "," + "frequency"); // prints the header in
														// table2D
		pw.println();

		for (Object[] element : table2D) { // loop through rows in
															// table2D
			pw.write(element[0] + "," + element[1] + newLine);// writes
																		// a
																		// string
		}

		pw.close();
	}

	/**
	 * @param outputFile
	 * @param ngSize
	 * @throws FileNotFoundException
	 */

	public static void save(String outputFile, int ngSize)
			throws FileNotFoundException {
		save(table2D, outputFile, ngSize);
	}

	public int ngSize;

	public String outputFile;

	public String directory;

	public Parser(int ngSize, String outputFile, String directory) {
		this.directory = directory;
		this.ngSize = ngSize;
		this.outputFile = outputFile;
		// table2D = new Object[1000][2]; // May need to resize
	}

	public void parseDirectory() throws FileNotFoundException { // find
																// directory,
																// asks user
																// where
																// directory is
		File f = new File(directory); // fileDir, .textFiles
		String fileSeparator = FileSystems.getDefault().getSeparator(); // Separate
																		// values
																		// in
																		// string
		String[] files = f.list(); // String array
		for (String file : files) { // loop through list array
			parseFile(f.getAbsolutePath() + fileSeparator + file, ngSize);// returns
																			// file
																			// directory
																			// pathname
		}
		save(outputFile, ngSize);
	}
}
