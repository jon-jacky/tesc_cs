/**
 * Demonstrate standard I/O and command line arguments in Java
 *
 * Reads lines from standard input, writes same lines to standard output
 * until end of file.
 *
 * Optional command line argument is prompt string
 *
 *  @author J. Jacky  
 *  @version 3-Apr-2001 Written
 */

import java.io.*;

public class Echo { 
    public static void main(String args[]) throws IOException {
	String prompt, line;
	boolean bContinue = true;

	// Set up input - magic copied from O'Reilly JAVA EXAMPLES p. 14
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	// Optional command line argument is prompt
	if (args.length > 0)
	    prompt = args[0];
	else 
	    prompt = "";

	// Read input lines until end of file
	while (bContinue) {
	    System.out.print(prompt);
	    line = in.readLine();
	    if (line != null)
		System.out.println(line);
	    else 
		bContinue = false;
	}
    }
}
