//Data Structures and Algorithms
//Tod Antilla


public class Algorithm3{

    //counter keeps track of recursive calls
    static int counter = 0;
    
    //wrapper eliminates user having to add unnecessary parameters
    public static int maxSegmentSum(int[] A){
	counter = 0;
	return	recursive(0, A, 0, A.length-1);
    }
    //replaces excessive 'if' statements
    public static int max(int x, int y){
	if(x > y){return x;}
	else{return y;}
    }
    //Bently's recursive function
    private static int recursive(int maximum,
				      int[] A, int lowerIndex, int upperIndex){
	counter++;
	int middleIndex = (int) (lowerIndex + upperIndex) / 2,
	    sum = 0,
	    maxLeft = 0,
	    maxRight = 0,
	    maxMiddle = 0,
	    maxCrossLeft = 0,
	    maxCrossRight = 0;	
	
	//base case
	if(upperIndex == lowerIndex){
	    if(maximum > 0){return maximum;}
	    else{return 0;}
	}
	//maxCrossLeft
	for(int i=middleIndex; i>=lowerIndex; i--){
	    sum += A[i];
	   maxCrossLeft = max(maxCrossLeft, sum);
	}
	//maxCrossRight
	sum = 0;
	for(int i=middleIndex + 1; i<=upperIndex; i++){//cross right side
	    sum += A[i];
	    maxCrossRight = max(maxCrossRight, sum); 
	}

	maxMiddle = maxCrossLeft + maxCrossRight;
	maxLeft = recursive(maximum, A, lowerIndex, middleIndex);	
	maxRight = recursive(maximum, A, middleIndex + 1, upperIndex);

	maximum = max(maximum, maxMiddle);
	return max(max(maximum, maxLeft), max(maximum, maxRight));
    }
    
}







