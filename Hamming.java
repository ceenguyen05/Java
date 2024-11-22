import java.io.*; // imports the package neccessary to use input and output files 
import java.util.*; // used to read input with Scanner 

// Casey Nguyen 
// 09/05/2024
// COSC 2425 - 51700 , Professor Martinez 

// Program Purpose :
// This program reads a text file, input.txt. 
// For each character, it produces a hexadecimal number which is the hamming 
// code for 8-bit characters using even parity. These hex numbers are written to hamming.txt
// Copyright (c) Paul Koester, Dallas County Community College, 2017
// put in an output file and will display errors to the user 
// TODO : learn and add comments describing the process
// i will make a comment on things this code does and what I learned 

// test data is the hamming.txt file that contains code that needs to be decoded and translated into the 
// output file 
// expected translation of hamming.txt to output.txt is COSC 2425 Hamming code input file

public	class Hamming
	{
	 
	private char letter;      // The Ascii character with no parity bits
	private int[] bits = new int[12];
	private int code;         // The integer value of the character with the parity bits added
	
	public Hamming(char let) { letter = let; encode(); } // constructor , holds a char and calls encode 
	public Hamming(int c) { code = c; decode(); } // constructor for decoding 
	public int getCode() { return code; } // accessor 
	public char getLetter() { return letter; } // retrieves decoded characters 

    // encodes an 8-bit character into a 12-bit Hamming code with 4 parity bits for error detection/correction.
	private void encode() {
		int value = letter; // converts the ascii letter to a integer value 
		
		// Set value bits
		for (int i = 0; i < 12; i++) {
			if (i != 0 && i != 1 && i != 3 && i != 7) {
				bits[i] = value % 2;
				value /= 2;
			}
		}
		
		// Set parity bits
		bits[0] = bits[2] ^ bits[4] ^ bits[6] ^ bits[8] ^ bits[10]; // ^ is XOR in Java
		bits[1] = bits[2] ^ bits[5] ^ bits[6] ^ bits[9] ^ bits[10];
		bits[3] = bits[4] ^ bits[5] ^ bits[6] ^ bits[11];
		bits[7] = bits[8] ^ bits[9] ^ bits[10] ^ bits[11];

		// compute integer code
		// restructure into the 12-bit hamming we want 
		code = 0;
		for (int i = 11; i >= 0; i--) {
			code *= 2;
			code += bits[i];
		}
	}

    // decodes a 12-bit Hamming code and corrects any single-bit errors.
	private void decode() {
		int error = 0;
		int value = code; // stores the value for processing 

		// Set the bit array
		// stores the bits into the bits array to be stored and processed 
		for (int i = 0; i < 12; i++) {
			bits[i] = value % 2;
			value /= 2;
		}

		// Check for transmission errors
		// error variable is used to check exact bit that needs correction 
		if (bits[0] != (bits[2] ^ bits[4] ^ bits[6] ^ bits[8] ^ bits[10])) error += 1; 
		if (bits[1] != (bits[2] ^ bits[5] ^ bits[6] ^ bits[9] ^ bits[10])) error += 2;
		if (bits[3] != (bits[4] ^ bits[5] ^ bits[6] ^ bits[11])) error += 4;
		if (bits[7] != (bits[8] ^ bits[9] ^ bits[10] ^ bits[11])) error += 8;
		
		// Correct Error
		if (error != 0)
			bits[error - 1] ^= 1;

		// Extract character
		letter = 0;
		for (int i = 11; i >= 0; i--) {
		    // skips bits that do not belong
			if (i != 0 && i != 1 && i != 3 && i != 7) {
				letter *= 2;
				letter += bits[i];
			}
		}
		// Display where error detected
		if (error != 0)
			System.out.println("Error in bit " + (error - 1) + " corrected in character " + letter);
	}

    // main function to call and store everything 
	public static void main(String[] args) throws FileNotFoundException
	{
	    // Scanner to open the input file called hamming.txt
		Scanner  inFile = new Scanner( new File("hamming.txt"));
		// PrintStream opened to write to the output.txt file
		PrintStream outFile = new PrintStream(new File("output.txt"));
		String line;
		int code;
		
		System.out.println("File hamming.txt opened");	
		while (inFile.hasNextInt(16)) { // checks if the file has a hexadecimal number 
				code = inFile.nextInt(16); // reads the next number 
				// Decode the Hex code to get a character
				
				// Create a Hamming object
				Hamming ham = new Hamming(code); // creates Haming(code) to decode hexadecimal number 
					
				// Display the decoded character
				outFile.print(ham.getLetter()); // goes to the output.txt file 
			
			}
		inFile.close(); // close the file when done decoding 
		System.out.println("File output.txt closed"); // output to the user 
	}
}
