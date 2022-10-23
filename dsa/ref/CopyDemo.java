class Thing {
    int x;
    public Thing(int i) { x = i; }
}

public class CopyDemo {
    public static void main(String[] argv) {
	int i = 0, j = 1;
	System.out.println("1. i is " + i + "  j is " + j + 
			   "       i == j is " + (i == j));
	j = i;
	System.out.println("2. i is " + i + "  j is " + j + 
			   "       i == j is " + (i == j));
	i = i + 1;
	System.out.println("3. i is " + i + "  j is " + j +
			   "       i == j is " + (i == j));
	j = j + 1;
	System.out.println("4. i is " + i + "  j is " + j +
			   "       i == j is " + (i == j));

	Thing a = new Thing(0); Thing b = new Thing(1);
	System.out.println("5. a.x is " + a.x + "  b.x is " + b.x +
			   "   a == b is " + (a == b));
	b = a;
	System.out.println("6. a.x is " + a.x + "  b.x is " + b.x + 
			   "   a == b is " + (a == b));
	a.x = a.x + 1;
	System.out.println("7. a.x is " + a.x + "  b.x is " + b.x +
			   "   a == b is " + (a == b));

	Thing c = new Thing(1);
	System.out.println("8. a.x is " + a.x + "  c.x is " + c.x +
			   "   a == c is " + (a == c));
    }
}


