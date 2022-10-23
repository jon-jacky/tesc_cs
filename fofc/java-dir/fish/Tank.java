/** 
 * Tank.java - An object that contains other objects - a whole array of them
 *
 * @author J. Jacky
 * @version 06-May-2001 Written
 */

public class Tank {
    // No class variables

    // Class method - returns random integer from range 0 .. max 
    static int randint(int max) { 
	return (int) Math.round(max * Math.random()); // cast long to int
    }

    // Instance variables
    int width, depth; // dimensions of tank
    int nfish; // number of fish in tank
    SwimmingFish fish[]; // all the fish are stored in this array

    // Constructor
    public Tank(int n, int w, int d, int max_speed) { 
	nfish = n; width = w; depth = d;
	fish = new SwimmingFish[nfish]; // create array just big enough
	for (int i = 0; i < nfish; i++) { // loop over array elements
	    fish[i] = // call SwimmingFish constructor for each array element
		new SwimmingFish("f" + i, // id is fn where n is fish number
			     // put fish randomly around tank
			     (randint(1) > 0) ? true : false, // swim_right
			     randint(depth), // depth
			     randint(width), // distance
			     randint(max_speed) // speed
			     );
	}
    }

    // Time elapses, fish swim around
    public void tick(int time) {
	for (int i = 0; i < nfish; i++) fish[i].swim(time);
    }

    // Draw a picture of the tank 
    // At each row and column, if a fish is there, draw it
    public void draw() { 
	for (int row = 0; row < depth; row++) { // Loop over rows (depths)
	    // Put row number at the left edge of the picture, just one digit
	    System.out.print(row % 10); // % remainder operator for one digit
	    for (int col = 0; col < width; col++) { //Loop over cols(distances)
		// Is there a fish here? Must test each fish
		for (int i = 0; i < nfish; i++) { // Loop over fish
		    // If this fish is here, draw it
		    if (row == fish[i].depth && col == fish[i].distance) 
			fish[i].draw();
		} // end loop over fish, index i
		// This is very crude, rows with fish in them will be too wide
		System.out.print(" "); // print space, whether or not fish here
	    } // end loop over columns
	    System.out.println(); // line break at the end of the row
	} // end loop over rows
	for (int col = 0; col < width; col++) 
	    // Put column number along bottom edge of picture, just one digit
	    System.out.print(col % 10); // % remainder operator for one digit
	System.out.println(); // line break after bottom border of tank
    } // end draw method
} // end Tank class
