package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tCase = 0; tCase < t; tCase++) {
			int k = sc.nextInt();
			int[] p = new int[k + 1];
			int[] sum = new int[k + 1];
			int[][] dp = new int[k + 1][k + 1];
			sum[0] = 0;

			for (int i = 1; i <= k; i++) {
				p[i] = sc.nextInt();
				sum[i] = sum[i - 1] + p[i];
				for (int j = i; j <= k; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}

			System.out.println(new Main().solve(p, sum, dp, 1, k));
		}
	}

	public int solve(int[] p, int[] sum, int[][] dp, int a, int b) {
		if (a >= b) {
			return 0;
		} else if (dp[a][b] < Integer.MAX_VALUE) {
			return dp[a][b];
		} else if (a + 1 == b) {
			dp[a][b] = p[a] + p[b];
			return dp[a][b];
		} else {
			for (int i = a; i < b; i++) {
				int val = solve(p, sum, dp, a, i) + solve(p, sum, dp, i + 1, b) + sum[b] - sum[a - 1];
				dp[a][b] = Math.min(dp[a][b], val);
			}
			return dp[a][b];
		}
	}
}