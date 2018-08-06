package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] card = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				card[j] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n][n];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					dp[j][k] = 0;
				}
			}

			System.out.println(new Main().solve(card, dp, 0, n - 1));
		}
	}

	public int solve(int[] card, int[][] dp, int left, int right) {
		if (dp[left][right] > 0) {
			return dp[left][right];
		} else if (left == right) {
			dp[left][right] = card[left];
			return card[left];
		} else {
			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += card[i];
			}

			dp[left][right] = sum - Math.min(solve(card, dp, left + 1, right), solve(card, dp, left, right - 1));
			return dp[left][right];
		}
	}
}