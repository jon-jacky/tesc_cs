//Data Structures and Algorithms
//Tod Antilla


public class Algorithm3Driver{   

    public static void main(String argv[]){
	
        int[] A = new int[Integer.parseInt(argv[0])];

	
	
	testData(A, Boolean.valueOf(argv[1]).booleanValue());
    }
    static void testData(int[] test, boolean answer){

	if(answer){
	    for(int i=0; i<test.length - 1; i++){
		switch(i){
		case 0: 
		    test[0] = 10000; 
		    test[1] = -10000;
		    break;
		default:
		    if(i == test.length - 2){
			test[test.length-2] = -10000;
			test[test.length-1] = 10000;			
		    }
		    else{
			test[i] = -10000;
			test[i+1] = 10000;
			test[i+2] = -10000;
		    }
		}
		for(int j=0; j<test.length; j++){
		    if(j != i && j != i+1 && j != i+2){
			test[j] =  (int) (100 * (Math.random()-0.5));
		    }
		}
		printArray(test);
		if(Algorithm3.maxSegmentSum(test) != 10000){
		    System.out.println("Error");
		}
		else{
		    System.out.println("Max: "+ Algorithm3.maxSegmentSum(test));
		}
	    }
	}
    }

	static void printArray(int[] A){
	    System.out.print("\n[ "+A[0]);
	    for(int i=1; i<A.length-1; i++){
		System.out.print(", "+A[i]);
	    }
	    System.out.println(", "+A[A.length-1]+" ]");
	}
	
	
    }
    
    

    
    




