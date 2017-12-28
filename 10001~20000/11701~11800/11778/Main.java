package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long m = sc.nextLong();
		long n = sc.nextLong();

		long x = Math.max(m, n);
		long y = Math.min(m, n);

		while (x % y != 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}

		System.out.println(new Main().pibo(y));
	}

	public long pibo(long n) {
		if (n == 0) {
			return 0;
		} else {
			long[] val = { 1, 0, 0, 1 };
			long[] mat = { 1, 1, 1, 0 };
			while (n > 0) {
				if (n % 2 == 1) {
					mulmat(val, mat);
				}
				mulmat(mat, mat);
				n /= 2;
			}
			return val[1];
		}
	}

	public void mulmat(long[] a, long[] b) {
		int mod = 1000000007;
		long[] ta = a.clone();
		long[] tb = b.clone();

		a[0] = (ta[0] * tb[0] + ta[1] * tb[2]) % mod;
		a[1] = (ta[0] * tb[1] + ta[1] * tb[3]) % mod;
		a[2] = (ta[2] * tb[0] + ta[3] * tb[2]) % mod;
		a[3] = (ta[2] * tb[1] + ta[3] * tb[3]) % mod;
	}
}