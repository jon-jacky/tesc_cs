/*	Algorithm4.java
	Created on 10-9-2001
	By Abe, Eric, Jester and Joan (In alphabetical order :)
*/

public class Algorithm4 {

    // Method to find the largest contiguous segment
    // in an arbitrary length array
    public static int maxSegmentSum(int array[]) {

        // Variables to keep longest sum, and current running sum
        int maxendinghere = 0;
        int maxsofar	= 0;

        // Loop to see all elements in the array
        for (int i = 0; i < array.length;i++) {
	    // keep a running total of the sum of this segment
	    maxendinghere += array[i];

	    //  Check to see if a new largest array segment has been
	    //  found if not, make sure the current segment has not
	    //  fallen below 0, if it has reset and start a new segment

	    if (maxendinghere > maxsofar) {
		maxsofar =  maxendinghere;
	    }
	    if (maxendinghere < 0) {
		maxendinghere = 0;
	    }
	}
	return maxsofar;
    }
}
