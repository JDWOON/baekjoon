import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int[][] area = new int[2][n];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					area[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write(solve(area, n, w) + "\n");
		}

		bw.flush();
	}

	public static int solve(int[][] area, int n, int w) {
		int[][] dp = new int[n + 1][3];
		dp[0][0] = 0;
		dp[0][1] = 1;
		dp[0][2] = 1;

		for (int i = 0; i < n; i++) {
			getDP(area, dp, n, w, i);
		}

		int result = dp[n][0];

		if (n > 1) {
			if (area[0][n - 1] + area[0][0] <= w && area[1][n - 1] + area[1][0] <= w) {
				dp[0][0] = 4;
				dp[1][0] = 2;
				dp[1][1] = 3;
				dp[1][2] = 3;

				for (int i = 1; i < n - 1; i++) {
					getDP(area, dp, n, w, i);
				}

				result = Math.min(result, dp[n - 1][0]);
			}

			if (area[0][n - 1] + area[0][0] <= w) {
				dp[0][0] = 4;
				dp[1][0] = 2;
				dp[1][1] = 3;
				dp[1][2] = area[1][0] + area[1][1] <= w ? 2 : 3;

				for (int i = 1; i < n - 1; i++) {
					getDP(area, dp, n, w, i);
				}

				result = Math.min(result, dp[n - 1][2]);
			}

			if (area[1][n - 1] + area[1][0] <= w) {
				dp[0][0] = 4;
				dp[1][0] = 2;
				dp[1][1] = area[0][0] + area[0][1] <= w ? 2 : 3;
				dp[1][2] = 3;

				for (int i = 1; i < n - 1; i++) {
					getDP(area, dp, n, w, i);
				}

				result = Math.min(result, dp[n - 1][1]);
			}
		}

		return result;
	}

	public static void getDP(int[][] area, int[][] dp, int n, int w, int now) {
		dp[now + 1][0] = Integer.min(dp[now][1] + 1, dp[now][2] + 1);
		if (area[0][now] + area[1][now] <= w) {
			dp[now + 1][0] = Integer.min(dp[now + 1][0], dp[now][0] + 1);
		}
		if (now > 0 && area[0][now] + area[0][now - 1] <= w && area[1][now] + area[1][now - 1] <= w) {
			dp[now + 1][0] = Math.min(dp[now + 1][0], dp[now - 1][0] + 2);
		}

		dp[now + 1][1] = dp[now + 1][0] + 1;
		if (now == n - 1 || area[0][now] + area[0][now + 1] <= w) {
			dp[now + 1][1] = Math.min(dp[now + 1][1], dp[now][2] + 1);
		}

		dp[now + 1][2] = dp[now + 1][0] + 1;
		if (now == n - 1 || area[1][now] + area[1][now + 1] <= w) {
			dp[now + 1][2] = Math.min(dp[now + 1][2], dp[now][1] + 1);
		}
	}
}