package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		while (n > 0 && k >= 0) {
			k = Math.min(k, n - k);
			BigInteger result = new BigInteger("1");

			for (int i = n; i > n - k; i--) {
				result = result.multiply(new BigInteger(Integer.toString(i)));
			}

			for (int i = 2; i <= k; i++) {
				result = result.divide(new BigInteger(Integer.toString(i)));
			}

			System.out.println(result);

			n = sc.nextInt();
			k = sc.nextInt();
		}
	}
}