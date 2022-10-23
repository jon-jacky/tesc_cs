public class TicketDemo {
    public static void main(String[] args) {
	Ticket a, b, c;
	Ticket.total();
	a = new Ticket(); a.speak(); Ticket.total();
	b = new Ticket(); b.speak(); Ticket.total();
	c = new Ticket(); c.speak(); Ticket.total();
    }
}
