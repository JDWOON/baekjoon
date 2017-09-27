package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for (int i = 0; i < c; i++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			int avr = 0;

			for (int j = 0; j < n; j++) {
				p[j] = sc.nextInt();
				avr += p[j];
			}

			avr /= n;
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				if (p[j] > avr) {
					cnt++;
				}
			}

			double result = (double) Math.round((double) cnt / (double) n * 100000) / 1000;
			System.out.println(String.format("%.3f", result)+"%");
		}
	}
}