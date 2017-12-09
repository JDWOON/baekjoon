package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] p = new boolean[10001];
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i < 100; i++) {
			for (int j = i * 2; j < 10001; j += i) {
				p[j] = false;
			}
		}

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a = 0, b = 0;

			for (int j = 2; j <= n / 2; j++) {
				if (p[j] && p[n - j]) {
					a = j;
					b = n - j;
				}
			}
			System.out.println(a + " " + b);
		}
	}
}