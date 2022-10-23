public class Alpha {
    static boolean p = false;

    public static void main(String args[]) {
	logic(p);          
	Beta.logic(p);     
	logic(Beta.p);     
	Beta.logic(Beta.p);
    }

    public static void logic(boolean p) {
	boolean q = false;
	System.out.println(" p " + p + "   q " + q
			   + "    p && q  " + (p && q) 
			   + "    p || q  " + (p || q));
    }
}

class Beta {
    static boolean p = true;

    public static void logic(boolean p) {
	boolean q = true;
	System.out.println(" p " + p + "   q " + q
			   + "    p && q  " + (p && q) 
			   + "    p || q  " + (p || q));
    }
}
