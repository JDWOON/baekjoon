package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[m][n];
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}

		System.out.println(new Main().solve(map, dp, m, n, 0, 0));
	}

	public int solve(int[][] map, int[][] dp, int m, int n, int x, int y) {
		int val = 0;
		if (dp[x][y] != -1) {
			val = dp[x][y];
		} else if (x == m - 1 && y == n - 1) {
			dp[x][y] = 1;
			val = dp[x][y];
		} else {
			if (x > 0 && map[x][y] > map[x - 1][y]) {
				val += solve(map, dp, m, n, x - 1, y);
			}
			if (y > 0 && map[x][y] > map[x][y - 1]) {
				val += solve(map, dp, m, n, x, y - 1);
			}
			if (x < m - 1 && map[x][y] > map[x + 1][y]) {
				val += solve(map, dp, m, n, x + 1, y);
			}
			if (y < n - 1 && map[x][y] > map[x][y + 1]) {
				val += solve(map, dp, m, n, x, y + 1);
			}
			dp[x][y] = val;
		}
		return val;
	}
}