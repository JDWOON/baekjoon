package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long t = sc.nextLong();
		for (long i = 0; i < t; i++) {
			long n = Math.abs(sc.nextLong() - sc.nextLong());
			long k = 0;
			long temp = 0;

			if (n < 3) {
				k = n;
			} else {
				for (k = 3; temp < n; k++) {
					if (k % 2 == 1) {
						temp = (k / 2 + 1) * (k / 2 + 1);
					} else {
						temp = k / 2 * (k / 2 + 1);
					}
					continue;
				}
				k--;
			}
			System.out.println(k);
		}
	}
}