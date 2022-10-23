/** 
 * SwimmingFish.java - simple inheritance demo
 *
 * @author J. Jacky
 * @version 01-May-2001 begun, 02-May-2001 add turn, swim methods
 */

// SwimmingFish is a subclass of Fish
public class SwimmingFish extends Fish {
    // class variables, declared with static keyword
    // there is also a class variable n in Fish
    static int n = 0; // number of SwimmingFish spawned, start with none

    // class methods, declared with static keyword
    // there is also a class method census in Fish, this shadows it
    public static void census() { // no parameters, empty parameter list
	System.out.println(n + " swimming fish have been spawned");
    }

    // instance variables, in addition to those in Fish
    int depth; // vertical position: depth below surface, in lines
    int distance; // horiz. position: distance from left edge, in characters
    int speed; // speed fish is swimming, in characters per time unit

    // constructor method creates a new instance
    public SwimmingFish(String id, boolean rt, int y, int x, int v) {
	super(id, rt); // calls Fish constructor from superclass
	depth = y; distance = x; speed = v;
	n++; // count the new swimming fish
    }

    // instance method calls instance method from superclass
    public void stats() {
	draw(); // call draw instance method in superclass for this instance
	System.out.println("  depth " + depth + "  distance " + distance
			   + "  speed " + speed);
    }

    public void turn() { swim_right = !swim_right; } // reverse direction

    public void swim(int time) {
	if (swim_right)
	    distance = distance + speed * time; // further to the right
	else 
	    distance = distance - speed * time; // back to the left
    }
}
