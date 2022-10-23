/* Data Structures and Algorithms Assignment 2
   This generates either a static array, or a random array
   To create a random array pass true, the array size, and the maximum
   value of any one element

   Jim Geer */

public class LoadArray {

  public static int[] a;
  public static int[] b = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
  //public static int[] c; no longer needed



  public static int randomNumber = 0;


  public static int[] genArray(boolean ranArray, int arraySize, int maxValueSize){


    if (ranArray) {
      /* generate random array */
      a = new int[arraySize];
      for (int i=0; i <= arraySize - 1; i++){
        a[i] = (int)(Math.random()*((long)2 * maxValueSize) - maxValueSize);//creates 
        //negivative  and postive numbers
        //c = a; c=a executes i number of times within the loop, doesn't make sense.
      
      }
    	return a;
    }
    else {
    	return b;//no need to copyto c before returning.
    }
  }
}





