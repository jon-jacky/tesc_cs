// SleeperDemo.java - demonstrate threads and sleep
// Threads provide a way for one task to work while others are waiting

// Define threads by subclassing Thread
class Sleeper extends Thread {
    // instance methods, each thread is an object, gets its own copies of these
    public String id;  // identify yourself
    public long delay; // delay in milliseconds

    // constructor - pass information into the thread here
    public Sleeper(String s, long n) {  
	id = s; delay = n; // assign instance variables
    }

    // run method describes the computation in each thread
    // "run" method in each thread is like "main" method in program
    // run takes no arguments, use constructor to pass info
    // this run method just announces itself and waits, repeated ten times
    public void run() { 
	for (int i = 0; i < 10; i++) { // repeat ten times
	    // announce yourself
	    System.out.println("Thread "+id+" after "+ i*delay/1000.0 +" sec");
	    // now wait
	    try { sleep(delay); } // might throw ex, compiler demands we handle
	    catch (InterruptedException e) { } // needn't do anything
	}
        return; // thread exits after ten naps
    }
}

public class SleeperDemo {
    public static void main(String[] argv) { // create threads and start them
	Sleeper s1 = new Sleeper("s1", 500); s1.start();  // half second delay
	Sleeper s2 = new Sleeper("s2", 1000); s2.start(); // one second delay
    }
}
