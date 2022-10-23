class Thing {
    // Instance variables
    Thing next;
    int i;
    String s;

    // Constructor
    public Thing(int x, String msg) { i = x; s = msg; next = null; }
}

public class ThingDemo {
    public static void main(String argv[]) {
        Thing thing1 = null, thing2 = null;
	Thing list = null, temp = null, ref = null;
        
	// 1.
	thing1 = new Thing(99, "Hi");
	thing2 = thing1;
	System.out.println("thing1  i " + thing1.i + "  s " + thing1.s +
			   "   thing2  i " + thing2.i + "  s " + thing2.s);
	System.out.println("thing1.i == thing2.i " + (thing1.i == thing2.i) +
			   "   thing1.s == thing2.s " + (thing1.i == thing2.i) +
			   "   thing1 == thing2 " + (thing1 == thing2));

	// 2.
	thing2.s = "Bye";
	System.out.println("thing1.s " + thing1.s + "  thing2.s " + thing2.s +
			   "   thing1 == thing2 " + (thing1 == thing2));

	// 3.
	thing2 = new Thing(99, "Bye");
	System.out.println("thing1.s " + thing1.s + "  thing2.s " + thing2.s +
			   "   thing1 == thing2 " + (thing1 == thing2));
	
	// 4.
	thing2 = new Thing(99, "Foo");
	System.out.println("thing1.s " + thing1.s + "  thing2.s " + thing2.s +
			   "   thing1 == thing2 " + (thing1 == thing2));
	

	// 5.
	list = new Thing(1, "A");
	temp = new Thing(2, "B");
	temp.next = list;
	list = temp;
	System.out.println("list.i " + list.i + "  list.s " + list.s +
			   "  list.next.i " + list.next.i + 
			   "  list.next.s " + list.next.s);

	// 6.
	temp = new Thing(3, "C");
	temp.next = list;
	list = temp;

	System.out.print("list");
	for (ref = list; ref != null; ref = ref.next) {
	    System.out.print(" -> " + ref.s);
	}
	System.out.println(".");

	System.out.println("The i at the tail of the list is " 
			   + list.next.next.i);
    }
}




