public class ArraySum {

    public static int array_sum(int a[]) {
	int i, sum = 0;
	for (i = 0; i < a.length; i++) {
	    sum = sum + a[i];
	}
	return sum;
    }

    public static int signed_array_sum(boolean pos, int a[]) {
	int i, sum = 0;
	for (i = 0; i < a.length; i++) {
	    if (pos && a[i] > 0 || !pos && a[i] < 0) sum = sum + a[i];
	}
	return sum;
    }

}
