public class Ticket {
    static int n = 0;

    public static void total() { 
	System.out.println(n + " tickets have been issued");
    }

    int ticket;

    public Ticket() {
	ticket = n;
	n++;
    }

    public void speak() {
	System.out.println("I have ticket " + ticket);
    }
}

