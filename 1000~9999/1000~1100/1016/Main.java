package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long min = sc.nextLong();
		long max = sc.nextLong();
		long k = (long) Math.sqrt(max);
		boolean[] p = new boolean[(int) (max - min + 1)];

		for (long i = 0; i < max - min + 1; i++) {
			p[(int) i] = true;
		}

		for (long i = 2; i < k + 1; i++) {
			for (long j = min / (i * i); j <= max / (i * i); j++) {
				if (j * i * i >= min && j * i * i <= max) {
					p[(int) (j * i * i - min)] = false;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i]) {
				result++;
			}
		}

		System.out.println(result);
	}
}