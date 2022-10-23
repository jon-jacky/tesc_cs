/* In each method, I is the loop invariant */

public class Loops {
    public static int sum(int a[]) {
	int s = 0;
	for (int i = 0; i < a.length; i++) {
	    // I: s = a[0] + .. + a[i - 1] = sum of first i array elements
	    s = s + a[i]; // or s += a[i]
	}
	// i = length && I => s = a[0] + .. + a[length - 1] = sum of array
	return s;
    }

    // Invariants are clearer when we expand "for" loop to "while" loop:
    // for (s; p; u) { t; } expands to s; while (p) { t; u; }
    // In "while" form it is clearer that invariant holds both 
    // before and after loop body

    public static int sum2(int a[]) {
	int s = 0, i = 0;
	while (i < a.length) {
	    // I: s = a[0] + .. + a[i - 1] = sum of first i array elements
	    s = s + a[i]; // or s += a[i]
	    i = i + 1; // or i++
	}
	// i = length && I, so s = a[0] + .. + a[length - 1] = sum of array
	return s;
    }
	  
    public static int power(int x, int n) {
	int p = 1, i = 0;
	while (i < n) {
	    // I: p = x^i = x raised to the i power
	    p = p * x; // or p *= x
	    i = i + 1; // or i++
	}
	// i = n && I, so p = x^n = x to the n power
	return p;
    }

    public static int quotient(int n, int d) {
	int q = 0, r = n;
	while (r >= d) { 
	    // I: n = q*d + r
	    r = r - d; // or r -= d
	    q = q + 1; // or q++
	}
	// r < d && q*d + r
        // so q is the result of integer division of n by d, r is the remainder
	return q;
    }

    public static int f_quotient(int n, int d) {
	int r, q;
	for (r = n, q = 0; r >=d; q++) r -= d;
	return q;
    }

    public static int sqrt(int n) {
	int r = 1;
	while (n >= (r+1)*(r+1)) {
	    // I: r*r <= n
	    r = r + 1; // or r++
	}
	// r*r <= n && n < (r+1)*(r+1) so r is the integer square root of n
	return r;
    }
}
	


