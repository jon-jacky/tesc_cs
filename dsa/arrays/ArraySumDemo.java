public class ArraySumDemo {
    static int[] six_ones = {1,1,1,1,1,1};
    static int[] bentley = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
  
    static int[] half_neg = {1,1,1,-1,-1,-1};
    static int[] phase_one = {1,-1,1,-1,1-1};
    static int[] phase_two = {-1,1,-1,1,-1,1};

    public static void main(String argv[]) {
	System.out.println("The array of six ones adds up to "
			   + ArraySum.array_sum(six_ones));
	System.out.println("The positive elements in six ones add up to "
			   + ArraySum.signed_array_sum(true, six_ones));
	System.out.println("The negative elements in six ones add up to "
			   + ArraySum.signed_array_sum(false, six_ones));

	System.out.println("Bentley's array adds up to " 
			   + ArraySum.array_sum(bentley));
	System.out.println("The positive elements in Bentley's array add up to " 
			   + ArraySum.signed_array_sum(true, bentley));
	System.out.println("The negative elements in Bentley's array add up to " 
			   + ArraySum.signed_array_sum(false, bentley));
    }
}
