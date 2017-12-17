package baekjoon;

import java.util.Scanner;

public class Main {
	public static long mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long n = sc.nextLong();

		for (long i = 0; i < n; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			long m = sc.nextLong();
			System.out.println(new Main().getVal(a, b, x, y, m));
		}
	}

	public long getVal(long a, long b, long x, long y, long m) {
		long val = 1, ta, tb, tdiv;
		long top = (powMod(a, (x - y) % (mod - 1)) * powMod(b, (y - 1) % (mod - 1))) % mod;

		if (a == 1 && b == 1) {
			val = (m % mod) * ((m + 1) % mod) / 2;
		} else if (a == 1) {
			tb = ((powMod(b, m % (mod - 1)) - 1) * b - ((m % mod) * b) % mod + (m % mod) + mod) % mod;
			tdiv = ((b - 1) * (b - 1)) % mod;
			tdiv = powMod(tdiv, mod - 2);
			val = (tb * tdiv) % mod;
		} else if (b == 1) {
			ta = ((powMod(a, m % (mod - 1)) - 1) * a - ((m % mod) * a) % mod + (m % mod) + mod) % mod;
			tdiv = ((a - 1) * (a - 1)) % mod;
			tdiv = powMod(tdiv, mod - 2);
			val = (ta * tdiv) % mod;
		} else if (a == b) {
			ta = (a * (m % mod) - (m % mod) - 1 + mod) % mod;
			ta = (ta * powMod(a, m % (mod - 1)) + 1) % mod;
			tdiv = ((a - 1) * (a - 1)) % mod;
			tdiv = powMod(tdiv, mod - 2);
			val = (ta * tdiv) % mod;
		} else {
			ta = (powMod(a, (m + 1) % (mod - 1)) * (b - 1)) % mod;
			tb = (powMod(b, (m + 1) % (mod - 1)) * (a - 1)) % mod;
			tdiv = ((a - 1) * (b - 1)) % mod;
			if (a > b) {
				tdiv = (tdiv * (a - b)) % mod;
				val = (ta - tb + a - b + mod) % mod;
			} else {
				tdiv = (tdiv * (b - a)) % mod;
				val = (tb - ta + b - a + mod) % mod;
			}
			tdiv = powMod(tdiv, mod - 2);
			val = (val * tdiv) % mod;
		}
		val = (val * top) % mod;
		return val;
	}

	long powMod(long x, long pow) {
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