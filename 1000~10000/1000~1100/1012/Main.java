package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[][] field = new int[m][n];
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					field[a][b] = 0;
				}
			}
			for (int a = 0; a < k; a++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x][y] = 1;
			}

			int result = 0;
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					if (field[a][b] == 1) {
						result++;
						solve(field, m, n, a, b);
					}
				}
			}

			System.out.println(result);
		}
	}

	public static void solve(int[][] field, int m, int n, int x, int y) {
		if (x < 0 || y < 0 || x > m - 1 || y > n - 1) {
			return;
		} else if (field[x][y] == 1) {
			field[x][y] = 0;
			solve(field, m, n, x - 1, y);
			solve(field, m, n, x, y - 1);
			solve(field, m, n, x + 1, y);
			solve(field, m, n, x, y + 1);
		}
	}
}