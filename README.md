# N-Gram Generator

## Overview
The N-Gram Generator is a Java-based command-line interface (CLI) application designed to calculate probabilities of a sequence of letters or words. It plays a crucial role in augmentative and alternative communication systems, aiding in word prediction and suggestions. The core functionality of the program relies on utilizing language models, specifically n-grams where 'n' represents the length of the sequence of characters.

## Features

- **CLI Interface:** The program operates in a user-friendly command-line interface.
  
- **Dynamic N-Gram Selection:** Users can choose the size of the n-grams, with a recommended range of 1-5 to manage potential large outputs.

- **Flexible Input:** The program prompts users to specify the text file directory, facilitating the reading and processing of input text.

- **CSV Output:** The program generates a CSV file with two columns: N-Gram and Frequency, providing a clear representation of the results. CSV is recommended for its versatility and ease of use.

- **Menu-Driven Options:**
  - **1. Specify Text File Directory:** Input the directory containing the text file.
  - **2. Specify n-Gram Size:** Choose the desired size for the n-grams.
  - **3. Specify Output File:** Name the output file (CSV recommended).
  - **4. Build n-Grams:** Generate the n-grams and output the file.
  - **5. Quit:** Exit the program.

## How to Run

1. Specify the text file directory.
2. Choose the n-gram size.
3. Specify the output file name (CSV recommended).
4. Build the n-grams.
5. Quit the program.

### Usage Example

```bash
java -jar ngram-generator.jar
