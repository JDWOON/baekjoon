package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		m = sc.nextInt();
		int k = sc.nextInt();
		int[][] b = new int[m][k];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < k; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		int[][] p = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				p[i][j] = 0;
				for (int x = 0; x < m; x++) {
					p[i][j] += a[i][x] * b[x][j];
				}
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
}