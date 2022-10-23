// Link.java - Class for linked list, with operations to keep list sorted

public class Link {
    // Instance variables: each link contains these
    Link next; // reference (pointer) to next link
    String s;  // reference to contents of link, could have more/other data

    // Constructor: make Link with specified message and null reference
    public Link(String msg) { s = msg; next = null; }

    // Methods to create, process list
    // Use class methods so Link is always an argument to the method
    // rather than newfangled object-oriented style with instance methods

    // Add link to head of list, return reference to new head
    public static Link insertFront(Link head, Link newlink) {
	newlink.next = head;
	return newlink; 
    }

    // Print contents of list, an example of list traversal
    public static void printList(Link head) {
	Link link;
	System.out.print("head");
	for (link = head; link != null; link = link.next) {
	    System.out.print(" -> " + link.s);

	}
	System.out.println();
    }

    // Find item in list, an example of list traversal with test
    public static Link findLink(Link head, String msg) {
	Link link = head;
	// Search for link that *precedes* first link 
	// whose string equals or follows msg in ASCII sort order
	while (link != null && link.next != null 
	       && msg.compareTo(link.next.s) > 0) {
	    link = link.next;
	}
	// Return link where search succeeds, or last item in list,
	// or null if empty list
	return link;
    }

    // Insert item into list after oldlink
    public static void insertAfter(Link oldlink, Link newlink) {
	newlink.next = oldlink.next;
	oldlink.next = newlink;
    }

    // Add item to end of list 
    // ... 

    // Delete item from list 
    //  ...

}




