public class ItemDemo {
    public static void main(String argv[]) {
        Item head = null, newitem = null, ptr = null;

     // 1.
     head = new Item(1, "a");
     
     // 2.
     newitem = new Item(2, "b");

     // 3.
     newitem.next = head;
     head = newitem;

     // 4.
     newitem = new Item(3, "c");
     newitem.next = head;
     head = newitem;
     System.out.println(head.i + " " + head.next.i + " " + head.next.next.i);

     // 5.
     ptr = head;

     // 6.
     System.out.print("head -> " + ptr.i + ". " + ptr.s);

     // 7.
     ptr = ptr.next;

     // 8.
     if (ptr != null) { 
	 System.out.print(" -> " + ptr.i + ". " + ptr.s);
	 ptr = ptr.next;
     } else System.out.println(";");

     // 9.
     if (ptr != null) { 
	 System.out.print(" -> " + ptr.i + ". " + ptr.s);
	 ptr = ptr.next;
     } else System.out.println(";");

     // 10.
     if (ptr != null) { 
	 System.out.print(" -> " + ptr.i + ". " + ptr.s);
	 ptr = ptr.next;
     } else System.out.println(";");

     // 11.
     ptr = head;

     // 12.
     if (ptr != null && ptr.i != 2) {
	 ptr = ptr.next;
    } else System.out.println(ptr.i + ". " + ptr.s);

     // 13.
     if (ptr != null && ptr.i != 2) {
	 ptr = ptr.next;
    } else System.out.println(ptr.i + ". " + ptr.s);

     // 14.
     if (ptr != null && ptr.i != 2) {
	 ptr = ptr.next;
    } else System.out.println(ptr.i + ". " + ptr.s);

     // 15.
     ptr = head; System.out.print("head");
     while (ptr != null) { 
	 System.out.print(" -> " + ptr.i + ". " + ptr.s);
	 ptr = ptr.next;
     } 
     System.out.println(";");

     // 16.
     for (ptr = head; ptr != null && ptr.i != 2; ptr = ptr.next) ; // no body
     System.out.println(ptr.i + ". " + ptr.s);

    }
}



