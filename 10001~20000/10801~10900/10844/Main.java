package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int mod = 1000000000;
		int n = sc.nextInt();

		int[][] dp = new int[n + 1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		dp[1][0] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[n][i]) % mod;
		}

		System.out.println(sum);

	}
}