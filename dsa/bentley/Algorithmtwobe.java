
public class Algorithmtwobe {



    public static long go(int c[]) {

		long cumarray[]= new long [c.length + 1];//variable type is long, in order to hold large number
		cumarray[0] = 0;//cumarray first element is to be set 0

		for(int j = 0; j < c.length; j++){// pesudo code inital set number is 1 but in java it is 0
		     cumarray[j+1] = c[j] + cumarray[j];//Equalvent toCumArray[I-1]where1-1 equals 0
		 }

		//for (int i = 0; i < cumarray.length; i++){ for test purpose to see if array elemenats ar printing.
		 //System.out.println(cumarray[i]);
		//}
		long maxsofar = cumarray[1];//not 0, incase all elements of array are negative.
		
		long subtract ;
		
		for(int L =1 ; L < cumarray.length; L++){//Outer loop execute one time and it turns to inner loop


		    for(int U = L;  U < cumarray.length;U++){//let int U start from 1st element so it subtract 0.

				subtract = cumarray[U] - cumarray[L-1];//part of  inner loop  with different methods.
				if (maxsofar < subtract){
			    	maxsofar = subtract;//setting bigger value of cumarray[1]-cumarry[0],let maxsofar to be that bigger value.
	   
				}
		    }
		}
		return maxsofar;
    }
}
