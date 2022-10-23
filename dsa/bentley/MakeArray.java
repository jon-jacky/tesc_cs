/* This class builds an array of test data.  1s can be substituted if you
want an oracle.  It was designed by the Algorithm2 team.
    October 11, 2001
    */

public class MakeArray {

   public static int[] the_array(int a) {

       int[] buildit = new int [(a*100)];

       int[] copyme = {31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23,84,
                       31,-41,59,26,-53,58,97,-93,-23} ;

       for ( int x = 0 ; x < a ; x++ ) {

           buildit[(x*100)] = -1000000;

               for ( int y = 0 ; y < 99 ; y ++ ) {

                    buildit[(x*100)+1+y]= copyme[y];
               }

       }

       return buildit;

   }
}
