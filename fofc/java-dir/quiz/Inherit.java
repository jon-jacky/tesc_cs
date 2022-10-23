class Zeta {
    int i;
    public Zeta() { i = 0; }
    public void print_i() { System.out.print("  i " + i); }
}

class Sigma extends Zeta {
    int k; 
    public Sigma() { super(); k = 2; }
    public void print_k() { System.out.print("  k " + k); }
}

class Tau extends Sigma {
    int m;
    public Tau() { super(); m = 3; }
    public void print_m() { System.out.print("  m " + m); }
}

public class Inherit {
    public static void main(String argv[]) {
	Sigma s = new Sigma(); Tau t = new Tau();
	System.out.print("From s:"); s.print_i(); s.print_k(); 
	System.out.println();
	System.out.print("From t:"); t.print_i(); t.print_k(); t.print_m();
	System.out.println();
    }
}
