/*This is our solution for Algorithm2 from the Jon Bently Programming 
Pearls paper on Algorithm Design Techniques. 
    October 11, 2001
*/
 

public class Algorithm2 {

   public static int maxSegmentSum(int a[]) {

      int msf = 0;

      for ( int l = 0 ; l < a.length ; l++ ) {

          int sum = 0;

          for ( int u = l ; u < a.length ; u++ ) {

              sum = sum + a[u];

              if ( msf < sum ) msf = sum;
          }
      }
      return msf;
   }
}
