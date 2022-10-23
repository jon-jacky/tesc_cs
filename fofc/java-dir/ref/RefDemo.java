// RefDemo.java - demonstrate reference variables

// Trivial class - just one instance variable and a constructor
class Ref {
    int x; 

    // constructor: this.x is instance variable x, x is formal parameter x
    public Ref(int x) { this.x = x; } 
}

// Class for main method
public class RefDemo {
    
    static void addTenInt(int i) { // i is a local copy of the actual argument
	System.out.print("addTenInt: at entry i is " + i);
	i = i + 10; // add 10 to the local copy
	System.out.print(", at exit i is " + i); // print not println
    }

    static void addTenRef(Ref r) { // i is a copy of the reference argument
	System.out.print("addTenRef: at entry x is " + r.x);
	r.x = r.x + 10; // add 10 to the instance variable itself
	System.out.print(", at exit x is " + r.x); // print not println
    }

    public static void main(String[] argv) {
	int i, j; // Integers are Primitive types

	// Primitive types: assignment creates a new copy of the value
	i = 1; j = i;  System.out.println("Initially  i is " + i + ", j is " + j);
	i = 2; System.out.println("After i = 2, i is " + i + ", j is " + j);

	// Primitive types: method calls make a copy, act only on the copy
	addTenInt(i); 
	System.out.println(", after return i is " + i + ", j is " + j);
	addTenInt(j); 
	System.out.println(", after return i is " + i + ", j is " + j);
	System.out.println(); // blank line

	Ref a, b;       // Classes are reference types
	a = new Ref(1); // a is a reference to an object

	// References: assignment only copies the reference, not the object
	b = a; 
	System.out.println("Initially a.x is " + a.x + ", b.x is " + b.x);
	a.x = 2; 
	System.out.println("After a.x = 2, a.x is " + a.x + ", b.x is " + b.x);

	// References: method calls copy the reference, act on the object
	addTenRef(a); 
	System.out.println(", after return a.x is " + a.x + ", b.x is " + b.x);
	addTenRef(b); 
	System.out.println(", after return a.x is " + a.x + ", b.x is " + b.x);
    }
}






