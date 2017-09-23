package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] p = new int[2][41];
		p[0][0] = 1;
		p[0][1] = 0;
		p[1][0] = 0;
		p[1][1] = 1;

		for (int i = 2; i < 41; i++) {
			p[0][i] = p[0][i - 1] + p[0][i - 2];
			p[1][i] = p[1][i - 1] + p[1][i - 2];
		}

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(p[0][n] + " " + p[1][n]);
		}
	}
}