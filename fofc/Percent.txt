/**
 * Java version of FofC Winter Quarter Awk quiz
 *  see http://grace.evergreen.edu/~jackyj/fofc/percent.html 
 *
 *  @author J. Jacky  
 *  @version 17-May-2001 Written
 */

// java.lang has System class, but needn't import, it comes without asking
import java.io.*; // InputStreamReader, BufferedReader, PrintStream classes
import java.util.*;  // StringTokenizer class

public class Percent {
    // must declare exception 
    public static void main(String args[]) throws IOException {
	// Machinery not visible in Awk program
	int MAX = 10; // maxinum number of lines we can handle 
	String line;  // input line
	StringTokenizer st; // input line broken up into tokens

	// Variables from Awk program, use caps for NR so it looks like Awk
	int NR = 0;    // number of input lines, like built-in Awk variable
	int total = 0; // total of numbers on all input lines
	String id[] = new String[MAX]; // array of id strings, one per line
	int num[] = new int[MAX];      // array of numbers, one per line

	// Read the input file
	// System.in is Unix standard input
	// "in" is a class variable in java.lang.System
	// InputStreamReader, BufferedReader are classes in java.io
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// readLine is a class method in java.io.BufferedReader
	while ((line = in.readLine()) != null) { // Read line, check for eof
	    // StringTokenizer is a class in java.util
	    st = new StringTokenizer(line);
	    // nextToken is a method in StringTokenizer
	    id[NR] = st.nextToken(); // Awk $1
	    // parseInt is a class method in java.lang.Integer
	    num[NR] = Integer.parseInt(st.nextToken()); // Awk $2
	    total = total + num[NR];
	    NR++; // count lines
	}
       
	// Write output, figure percents
	// System.out is Unix standard output
	// out is a class variable of type PrintStream in java.lang.System
	// println is an instance method in java.io.PrintStream
	System.out.println(); // blank line
	for (int i = 0; i < NR; i++) {
	    System.out.println(id[i] + " " + num[i] + ", " 
			       + 100.0 * num[i]/total + "%");
	}
	System.out.println();
	System.out.println("Total: " + total);
    }
}














