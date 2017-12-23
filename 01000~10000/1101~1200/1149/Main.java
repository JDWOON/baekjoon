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
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + sc.nextInt();
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + sc.nextInt();
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + sc.nextInt();
		}

		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
	}
}