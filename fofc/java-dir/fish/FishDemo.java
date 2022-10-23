/**
 * FishDemo.java - demonstrate Fish objects
 *
 * @author J. Jacky
 * @version 24-Apr-2001
 */

// If the Fish class is in the current directory, you don't need import
// The compiler is smart: javac FishDemo.java will compile Fish.java also

public class FishDemo {
    public static void main(String[] argv) {
	Fish angel, goldie; // declare instances, type is class name

	Fish.census(); // call class method, should count no fish yet

	angel = new Fish("angel", true); // call constructor to create instance
	Fish.census(); // call class method, should count angel
	System.out.println(); // blank line before picture
	angel.draw(); // call instance method, angel should be pointing right
	System.out.println(); System.out.println(); // blank line after picture
	angel.swim_right = false; // assign instance veriable to change state
	angel.draw(); // now angel should be pointing left 
	System.out.println(); System.out.println(); // blank line after picture

	goldie = new Fish("goldie", true);  // create another instance
	Fish.census(); // call class method, should count angel and goldie
	System.out.println(); // blank line before picture
	goldie.draw(); // call instance method, draw goldie
	System.out.println(); System.out.println(); // blank line after picture
    } 
}







