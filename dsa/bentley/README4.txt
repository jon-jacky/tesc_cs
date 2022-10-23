Readme4.txt
These are instructions for running Driver4.java
Turn word wrap on if you only have a few lines that go off the screen.
It is under the menu Format, Edit or View in most editors

Compiling : javac Driver4.java
no extra details

Executing:
To execute Driver4, you must specify some details of the array you would like to test.
First i will define what you need to specify, then i will show the syntax for specifying
at the command line (where it all matters :)

The syntax for executing Driver4 is as follows:
java Driver4 (array length) (oracle start index) (oracle length) (algorithm)
each of the things in parenthesis are defined below.

(array length): Driver4 will generate an array of random data that is of a length that you specify at the command line.  If you want to test an array against a 100 element array, you can specify that, if you would like to use 159,324 elements, it will do that too.  This is the value that you will see from here on called (array length).  When you see (array length) remember that all this does tell the Driver at the command line how long of an array you would like it to generate

(oracle start index):  To test for possible points of failure in an algorithm, it is useful to be able test its boundaries.  To do this with Driver4, you simply install an oracle segment.  This is a segment with a known length, and a calculable value that will be consistently larger than any other segment in the array.  It is also useful to be able to place the oracle segment anywhere you want to test the boundaries.  This is what this parameter allows you to do.  By specifying various (oracle start index) values, you can push and pull the known segment around the array and see if you can find places where the algorithm fails to find, or finds the wrong value for the segment.  Long story made short; The (oracle start index) specifies where to start the oracle segment.  Remember, java's indexes start at 0, so if you want to start at the "Beginning" of the array, you want an index value of 0.

(oracle length): The other thing as i said before that an oracle had better do is be calculable.  This is where oracle length comes into play.  The oracle segment has a value of 100 in each element of the array (each box).  This way, you can tell Driver for to make an oracle 100 elements long, and you will know that this segment will have a value of 100*100 or 10,000.  Then if it returns something else, you know something went wrong.

(algorithm) is the algorithm number you would like to test.  This is just a number, except for algorithm 2b which is "2b".  acceptable inputs here are 1, 2, 2b, 3 or 4.  Only one algorithm can be tested at a time, entering multiple numbers here will be ignored, and only the first will be tested.

SAMPLE 1
java Driver4 1000 100 25 1
will generate a random array 1000 elements long, with an oracle segment installed starting an index value of 100 (which is the 101th element of the array!) that continues on filling in the next 25 elements of the array with the number 100.  The value of the oracle segment will then be 25*100 = 2500.  This array will then be passed to Algorithm1 for testing.

java Driver4 10000 999 1000 2b
This time it will generate a random array of 10000 elements, and will make an oracle from the 1000th element (index of 999!) to the 2000th element, with a value of 1000*100 = 100000, and will test it against algorithm 2b.

PROGRAM NOTES.  IMPORTANT! READ THIS CAREFULLY

This Driver is generating random numbers between -10 and 10.  If your oracle segment is short enough that its maximum value is not as big as some random segment in the array itself, you will not get the oracle value returned.  As a result of this, you may get back a sum that is larger than the oracle segment you installed.
for example:
Driver4 10000000 10 10 4
will generate an enormous 10 million element array, and the oracle segment will only be 10 elements long, for a value of 10 * 100 = 1000.  Out of an array of 10 million random values between -10 and 10 there are probably random segments that are larger, in fact, much larger, than 1000.  There are probably a few of them, possibly many.  It is almost guaranteed that if you execute the above command, you will not see it say "the max sum was 1000" but rather 1000 will be replaced by some random number much larger than 1000.  Careful of this!

If you do not like this feature, and would prefer to use larger values in each individual array element in your oracle sum, go to the second for loop, and change the line that says:
	testarray[i + args2] = 100;
to 
	testarray[i + args2] = (What ever larger or smaller value you'd like);
and it will start installing larger values.  Careful of this too however.
If you make an array of 10 million elements, and then make an oracle of half this array, say 5 million segments long, and you are filling them with values of 1000, your segments sum will no longer be an int, it will need a long, and will probably crash the algorithm you are testing.

Thats all we have to say....
Questions or comments, feedback good or bad can be given to Jester, Abe, Joan, or Eric.
Responses may vary ;P