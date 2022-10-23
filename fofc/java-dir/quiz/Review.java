public class Review {
    static boolean p = false;
    static boolean q = true;
    static boolean r = true;
    
    static int num[] = { 3, 2, 5 };
    static int t;

    public static void main(String argv[]) {

	System.out.println("p || q is " + (p || q));
	System.out.println("q || r is " + (q || r));
	System.out.println("p && q is " + (p && q));
	System.out.println("q && r is " + (q && r));
    
	if (p || q) {
	    System.out.println("p or q is true");
	}

	if (p && q) {
	    System.out.println("p and q is true");
	}

	t = 0;
	for (int i = 0; i < 3; i++) {
	    t = t + num[i];
	    System.out.println("i " + i + "  t " + t);
	}

	for (int i = 0; i < 3; i++) {
	    System.out.println(num[i] + ", " + 100.0*num[i]/t + "%");
	}
    }
}
