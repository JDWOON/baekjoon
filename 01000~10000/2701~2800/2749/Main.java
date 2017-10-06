package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong() % 1500000;
		int[] p = new int[(int) (n + 1)];

		p[0] = 0;
		p[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			p[i] = (p[i - 1] + p[i - 2]) % 1000000;
		}

		System.out.println(p[(int) n]);
	}
}