public class LinkDemo {
    public static void main(String argv[]) {
	Link head = null; // make a list in reverse sort order
	head = Link.insertFront(head, new Link("a")); // head -> a
	head = Link.insertFront(head, new Link("b")); // head -> b -> a
	head = Link.insertFront(head, new Link("c")); // head -> c -> b -> a
	Link.printList(head);

	head = null; // start over, this time make list in sort order
	head = Link.insertFront(head, new Link("u")); // head -> u
	head = Link.insertFront(head, new Link("o")); // head -> o -> u
	head = Link.insertFront(head, new Link("e")); // head -> e -> o -> u
	head = Link.insertFront(head, new Link("a")); // head -> a -> e -> o -> u
	Link.printList(head);
	
	// Insert item in order
	Link loc;
	loc = Link.findLink(head, "i");
	Link.insertAfter(loc, new Link("i")); // head -> a -> e -> i -> o -> u
	Link.printList(head);
    }
}

// For a somewhat different approach see the animations and code at 
// http://www.csc.liv.ac.uk/~davek/comp102/, follow link to Linked List


