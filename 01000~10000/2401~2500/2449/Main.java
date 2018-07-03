package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] light = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 100000;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			for (int i = j - 1; i > -1; i--) {
				for (int temp = i; temp < j; temp++) {
					int cnt = light[i] == light[temp + 1] ? 0 : 1;
					dp[i][j] = Math.min(dp[i][j], dp[i][temp] + dp[temp + 1][j] + cnt);
				}
			}
		}

		System.out.println(dp[0][n - 1]);
	}
}