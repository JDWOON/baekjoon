package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		new Main().solve(n, k);
	}

	public void solve(int n, int k) {
		long a = 1, b = 1, c = 1;
		long mod = 1000000007;

		for (int i = 2; i <= n; i++) {
			a = (a * i) % mod;
			if (i == k) {
				b = a;
			}
			if (i == n - k) {
				c = a;
			}
		}

		b = powMod(b, mod - 2, mod);
		c = powMod(c, mod - 2, mod);
		a = (((a * b) % mod) * c) % mod;

		System.out.println(a);
	}

	public long powMod(long x, long pow, long mod) {
		long result = 1;
		while (pow > 0) {
			if (pow % 2 == 1) {
				result = (result * x) % mod;
			}
			x = (x * x) % mod;
			pow /= 2;
		}
		return result;
	}
}