/* This is the driver program designed by the Algorithm2 team.
It calls a method to create 3 increasingly larger test 
arrays for Algorithm2.
   October 11, 2001
*/

public class TestMakeArray {
     public static void main(String argv[]) {
          System.out.println("TEST");
          int[] ourarray = MakeArray.the_array(1);
          int[] ourarray2 = MakeArray.the_array(10);
          int[] ourarray3 = MakeArray.the_array(100);
          int[] ourarray4 = MakeArray.the_array(500);

          System.out.println("Array one has " + ourarray.length 
                + " elements.");
          System.out.println("Element 0 is " + ourarray[0] + ".");
          System.out.println("-----");
          for (int m = 0; m < 100; m++ ) {System.out.print(ourarray[m] + ",");}
             System.out.println("-----");

             double first = System.currentTimeMillis();
             int q = Algorithm2.maxSegmentSum(ourarray);
             double second = System.currentTimeMillis()-first;
             System.out.println("The highest contiguous total is " + q + ".");
             System.out.println("The math took " + second + " milliseconds.");
             System.out.println();

             System.out.println("Array two has " + ourarray2.length 
                   + " elements.");
             double first2 = System.currentTimeMillis();
             int qq = Algorithm2.maxSegmentSum(ourarray2);
             double second2 = System.currentTimeMillis()-first2;
             System.out.println("The highest contiguous total is " + qq + ".");
             System.out.println("The math took " + second2 + " milliseconds.");
             System.out.println();

             System.out.println("Array three has " + ourarray3.length 
                   + " elements.");
             double first3 = System.currentTimeMillis();
             int qqq = Algorithm2.maxSegmentSum(ourarray3);
             double second3 = System.currentTimeMillis()-first3;
             System.out.println("The highest contiguous total is " 
                   + qqq + ".");
             System.out.println("The math took " + second3 + " milliseconds.");
             System.out.println();

             System.out.println("Array three has " + ourarray4.length 
                   + " elements.");
             double first4 = System.currentTimeMillis();
             int qqqq = Algorithm2.maxSegmentSum(ourarray4);
             double second4 = System.currentTimeMillis()-first4;
             System.out.println("The highest contiguous total is " 
                   + qqqq + ".");
             System.out.println("The math took " + second4 + " milliseconds.");
     }
}
