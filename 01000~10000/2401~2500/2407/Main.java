package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		m = Math.min(m, n - m);
		BigInteger result = new BigInteger("1");

		for (int i = n; i > n - m; i--) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}

		for (int i = 2; i <= m; i++) {
			result = result.divide(new BigInteger(Integer.toString(i)));
		}

		System.out.println(result);
	}
}