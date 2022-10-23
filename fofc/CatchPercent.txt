// Demonstrate Java exception handling: throw ... catch ...
// Based on Percent.java at http://grace.evergreen.edu/~jackyj/fofc/Percent.txt

import java.io.*; // InputStreamReader, BufferedReader, PrintStream classes
import java.util.*;  // StringTokenizer class

public class CatchPercent {
    // main does not catch IOException, so it might throw it.  must say so here
    public static void main(String args[]) throws IOException {
	int MAX = 10; // maxinum number of lines we can handle 
	String line;  // input line
	StringTokenizer st; // input line broken up into tokens

	int NR = 0;    // number of input lines, like built-in Awk variable
	int total = 0; // total of numbers on all input lines
	String id[] = new String[MAX]; // array of id strings, one per line
	int num[] = new int[MAX];      // array of numbers, one per line

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// try operations that might throw exceptions
	// if exception is thrown, control jumps out to matching catch
	try {
	    // readLine is a class method in java.io.BufferedReader
	    while ((line = in.readLine()) != null) { // Read line, check eof
		// StringTokenizer is a class in java.util
		st = new StringTokenizer(line);
		// nextToken is a method in StringTokenizer
		// nextToken can throw NoSuchElementException 
		// array access id[NR] can throw ArrayIndexOutOfBoundsException
		id[NR] = st.nextToken(); // Awk $1
		// parseInt is a class method in java.lang.Integer
		// can throw NumberFormatException
		num[NR] = Integer.parseInt(st.nextToken()); // Awk $2
		total = total + num[NR];
		NR++; //do this last so we only process lines before exception 
	    }
	} // end try

	// if exception thrown in try block, control jumps out here.
	// test for each possible exception in turn.
	// our handlers just report which exception occurred.
	// exceptions are objects so they can be passed to the println method
	catch (NoSuchElementException nse) {
	    System.out.println(nse); // prints name of exception
	}	
	catch (NumberFormatException nfe) {
	    System.out.println(nfe); // prints name of ex. and offending string
	}
	catch (ArrayIndexOutOfBoundsException abe) {
	    System.out.println(abe); // prints name of exception
	}

	// after catching any exception, control proceeds through here
	// works the way we want: process through last line before exception
	System.out.println(); // blank line
	for (int i = 0; i < NR; i++) {  // i<NR stops at last line before excpt
	    System.out.println(id[i] + " " + num[i] + ", " 
			       + 100.0 * num[i]/total + "%");
	}
	System.out.println();
	System.out.println("Total: " + total);
    }
}
