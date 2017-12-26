package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] dp = new int[n + 1][3];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;

		for (int i = 1; i <= n; i++) {
			int val = sc.nextInt();
			dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
			dp[i][1] = dp[i - 1][0] + val;
			dp[i][2] = dp[i - 1][1] + val;
		}

		System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
	}
}