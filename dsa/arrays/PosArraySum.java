public class PosArraySum {
    public static int pos_array_sum(int a[]) {
	int i, sum = 0;
	for (i = 3; i < a.length; i++) {
	    if (a[i] > 0) sum = sum + a[i];
	}
	return sum;
    }
}
