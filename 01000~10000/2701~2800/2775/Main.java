package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[15][15];
		for (int i = 1; i < 15; i++) {
			map[0][i] = i;
		}
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				int temp = 0;
				for (int m = 1; m <= j; m++) {
					temp += map[i - 1][m];
				}
				map[i][j] = temp;
			}
		}

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(map[k][n]);
		}
	}
}