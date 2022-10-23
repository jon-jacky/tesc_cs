/** 
 * Fish.java - simple object demo
 *
 * @author J. Jacky
 * @version 24-Apr-2001
 */

// It's a good idea to put just one class in a file.
// Fish is the class defined in this file, so the file must be named Fish.java
public class Fish {
    // class variables, declared with static keyword
    // there is one set of class variables for the entire class
    static int n = 0; // number of fish spawned, start with none

    // class methods, declared with static keyword
    public static void census() { // no parameters, empty parameter list
	System.out.println(n + " fish have been spawned");
    }

    // instance variables, declared without static keyword
    // there is one set of instance variables for each instance
    // instance variables store each instance's state
    String id; // identification string, fish's name
    boolean swim_right; // direction: true if fish is swimming to the right

    // instance methods, declared without static keyword

    // Constructure method that creates a new instance of the class.
    // The constructor is the same name as the class.  
    // The constructor declaration has no return type, body has no return
    public Fish(String name, boolean direction) { // spawn a new fish!
	id = name; swim_right = direction;
	n++; // count the new fish
    }

    // This instance method draws a little picture of the target instance
    // Draws the fish at the current cursor position
    // Leave it to the caller to set the cursor position before drawing
    public void draw() {
	if (swim_right) 
	    System.out.print(">`" + id + ",@>");
	else
	    System.out.print("<@," + id + "'<");
    }
}
