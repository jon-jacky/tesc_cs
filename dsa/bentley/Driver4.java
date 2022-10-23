/*	Driver4.java
	Created 10-9-2001
	By Abe, Eric, Jester and Joan (Again, In alphabetical order ;)
  Modified 10-11-2001 to accept command line arguments
  Modified 10-16-2001 to include switching among the different algorithms
                      from the command line.
  Modified 10-17-2001 to include more error checking, help, and code comments
*/
public class Driver4 {
	// This method takes 4 the command line parameters and produces random array, from
	// with which it tests the timing of the array run time. if there are no arguments
	// it just tests an array of 10,000 and 100,000 elements and times that


	static long runtimer;
	static long arraymax;
	public static void main (String[] args) {

      // initialize variables to be used in defining the characteristics
      // of the array.  They are initialized to 0 so that if no command line
      // parameters are given, the Driver can identify this problem and give
      // an error message.
	    int args1 = 0;
	    int args2 = 0;
	    int args3 = 0;
      int args4 = 0;

      // take values from the command line arguments, and convert them to useable
      // integer values.  If there are no command line arguments, catch the exception
      // and print an error message (java-speak for "handle the problem")
		try {
		args1 = Integer.parseInt(args[0]);
		args2 = Integer.parseInt(args[1]);
		args3 = Integer.parseInt(args[2]);
      // This is my cheesy way of identifying algorithm 2b, it works, but
      // but it ain't pretty :(
      if (args[3].endsWith("b") || args[3].endsWith("B")) {
      args4 = 5;
      }
      else {
       	args4 = Integer.parseInt(args[3]);
      }
    }
		catch (Exception e) {
		System.out.println("");
		System.out.println("You have not used the correct syntax when running this driver");
		}

		// test that all inputs are of the allowable values, and if so, generate the array
		if (args1 >= args2 + args3 && args1 >= 1 && args4 <= 5 && args4 != 0) {
			// create an array, "testarray", of the specified length
			int[] testarray = new int[args1];
      // fill the test array with integer values between -10 and 10
			for (int i = 0; i < args1; i++) {
				testarray[i] = (int)((Math.random() - .5) * 20);
			}
			// install the desired oracle segment, each element of which is filled with the
      // value of 100
			for (int i = 0; i < args3 ; i++){
				testarray[i + args2] = 100;
			}
			// chop the available ends of the segment.  If the oracle segment starts at the
      // beginning or ends at the end of the array, these statements throw exceptions
      // which can be ignored, as the array ends with the oracle.
      try {testarray[(args2 - 1)] = -100000000;} catch(Exception e){}
			try {testarray[(args2 + args3)] = -100000000;} catch(Exception e){}

 			// test the array against the specified algorithm, print out the sum the
      // algorithm found and the time it took to run the algorithm
			switch(args4) {
			case 1:
			System.out.println("Algorithm 1 found a maximum value of");
			runtimer = System.currentTimeMillis();
			arraymax = Algorithm1.maxSegmentSum(testarray);
			runtimer = System.currentTimeMillis() - runtimer;
			System.out.println(arraymax + " and executed in " + runtimer +
					   " milliseconds");
      break;
      case 2:
			System.out.println("Algorithm 2 found a maximum value of");
			runtimer = System.currentTimeMillis();
			arraymax = Algorithm2.maxSegmentSum(testarray);
			runtimer = System.currentTimeMillis() - runtimer;
			System.out.println(arraymax + " and executed in " + runtimer +
					   " milliseconds");
      break;
      case 5:
			System.out.println("Algorithm 2b found a maximum value of");
			runtimer = System.currentTimeMillis();
			arraymax = Algorithm2b.maxSegmentSum(testarray);
			runtimer = System.currentTimeMillis() - runtimer;
			System.out.println(arraymax + " and executed in " + runtimer +
					   " milliseconds");
      break;
      case 3:
			System.out.println("Algorithm 3 found a maximum value of");
			runtimer = System.currentTimeMillis();
			arraymax = Algorithm3.maxSegmentSum(testarray);
			runtimer = System.currentTimeMillis() - runtimer;
			System.out.println(arraymax + " and executed in " + runtimer +
					   " milliseconds");
      break;
      case 4:
			System.out.println("Algorithm 4 found a maximum value of");
			runtimer = System.currentTimeMillis();
			arraymax = Algorithm4.maxSegmentSum(testarray);
			runtimer = System.currentTimeMillis() - runtimer;
			System.out.println(arraymax + " and executed in " + runtimer +
					   " milliseconds");
      break;
    		}
      }
    // Remember that "test that all inputs are of the allowable values, and
    // if so, generate the array" from so many lines ago?  this is what happens
    // if one or more of those inputs are not correct
		else {
      System.out.println("");
			System.out.println("Please read the Readme4.txt file for an in depth description of");
      System.out.println("the syntax, and the output of this Driver.");
			System.out.println("The basic syntax is as follows;");
			System.out.println("java Driver4 (array length) (oracle start index) (oracle length) (algorithm)");
			System.out.println("The oracle value will be 100*(oracle length)");
			System.out.println("****     REMEMBER!!!  The array index starts at 0, NOT 1     ****");
			System.out.println("Got that? if not, READ THE README DAGNABIT! I WROTE IT FOR YOU!!!");
		}
	}
}
