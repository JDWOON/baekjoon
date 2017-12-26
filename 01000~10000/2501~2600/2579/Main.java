package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = sc.nextInt();
		dp[1][1] = dp[1][0];

		for (int i = 2; i < n + 1; i++) {
			int val = sc.nextInt();
			dp[i][1] = dp[i - 1][0] + val;
			dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + val;
		}

		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}