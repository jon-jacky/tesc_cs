import java.lang.Number.*;


public class AlgorithmtwobeDemo {
   public static void main(String argv[]){
    	long  a = 0;
    	int[] myarray;//array that i am going to run algorithm on
    	myarray = LoadArray.genArray(true, 200, Integer.MAX_VALUE);//not working, 
    		//cannot take the result of genArray and assign it to myarray
		
		a = System.currentTimeMillis();
		System.out.println(Algorithmtwobe.go(myarray));
		System.out.println("It takes " +(System.currentTimeMillis() -  a) + " Milliseconds to  process the random array");
		
		
		int[] bentlysArray;//array that i am going to run algorithm on
    	bentlysArray = LoadArray.genArray(false, 0, 0);//not working, 
    		//cannot take the result of genArray and assign it to myarray
		
		a = System.currentTimeMillis();//by use of Bently's array to see the results at the same time
		System.out.println(Algorithmtwobe.go(bentlysArray));
		System.out.println("It takes " +(System.currentTimeMillis() -  a) + " Milliseconds to  process Bently's array");
	
	}

}

