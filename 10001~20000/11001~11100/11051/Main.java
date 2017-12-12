package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = 0;
			}
		}

		System.out.println(new Main().solve(n, k, dp));
	}

	public int solve(int n, int k, int[][] dp) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		} else {
			if (n < 1 || k < 1 || n == k) {
				dp[n][k] = 1;
			} else {
				dp[n][k] = (solve(n - 1, k - 1, dp) + solve(n - 1, k, dp)) % 10007;
			}
			return dp[n][k];
		}
	}
}