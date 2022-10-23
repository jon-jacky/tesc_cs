public class Delta {
    static int a = 1;
    static int b = 3;

    public static void show(int b) {
	int c = 5;
	System.out.println(" a " + a + "  b " + b + "  c " + c);
    }

    public static void main(String argv[]) {
	show(b);
	show(Gamma.b);
	Gamma.show(b);
	Gamma.show(Gamma.b);
    }
}

class Gamma {
    static int a = 2;
    static int b = 4;

    public static void show(int b) {
	int c = 6;
	System.out.println(" a " + a + "  b " + b + "  c " + c);
    }
}
