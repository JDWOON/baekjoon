package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] dp = new int[n][n];
		dp[0][0] = sc.nextInt();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + sc.nextInt();
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + sc.nextInt();
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + sc.nextInt();
				}
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n - 1][i]);
		}

		System.out.println(result);
	}
}