/**
 * SwimmingFishDemo.java - demonstrate Fish objects
 *
 * @author J. Jacky
 * @version 01-May-2001 written, 02-May-2001 call turn, swim methods
 */

// If the Fish classes are in the current directory, you don't need import
// javac SwimmingFishDemo.java will compile Fish.java, SwimmingFish.java also

public class SwimmingFishDemo {
    public static void main(String[] argv) {
	Fish angel; // declare instances, type is class name
	SwimmingFish charlie; 

	Fish.census(); SwimmingFish.census(); // Count members of each class
	System.out.println(); // blank line for readability

	angel = new Fish("angel", true); // call constructor to create instance
	Fish.census(); SwimmingFish.census(); // Count members of each class
	System.out.println(); // blank line before picture
	angel.draw(); // call instance method, angel should be pointing right
	System.out.println(); System.out.println(); // blank line after picture

	charlie = new SwimmingFish("charlie", false, 2, 3, 1);
	Fish.census(); SwimmingFish.census(); // Count members of each class
	System.out.println(); // blank line before picture
	charlie.stats(); // charlie should be pointing left, also print stats
	System.out.println(); System.out.println(); // blank line after picture

	charlie.swim(1); charlie.stats(); 
	charlie.swim(1); charlie.stats(); 
	charlie.turn(); charlie.swim(1); charlie.stats(); 
    } 
}
