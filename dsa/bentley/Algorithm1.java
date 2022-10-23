/* Data Structures & Algorithms J Jacky Fall Qtr 2001
   Hugo Vo, Michael Jones, Joan Julius */





public class Algorithm1 {
  public static int maxSegmentSum(int a[]) {
    int MaxSoFar = 0;
    for (int L = 0; L < a.length; L++) {
      for (int U = L; U < a.length; U++) {
        int Sum = 0;
        for (int I = L; I <= U; I++) {
          Sum += a[I];
        }
        MaxSoFar = max(MaxSoFar, Sum);
      }
    }
    return MaxSoFar;
  }

 public static int max (int x, int y) {
    if (x > y)
      return x;
    else
      return y;
  }

}
