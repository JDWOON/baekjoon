import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] s = new int[2][n];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					s[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n + 1];
			Arrays.fill(dp[0], -1);
			Arrays.fill(dp[1], -1);
			dp[0][0] = 0;
			dp[1][0] = 0;
			dp[0][1] = s[0][0];
			dp[1][1] = s[1][0];

			bw.write(Math.max(solve(s, dp, 0, n), solve(s, dp, 1, n)) + "\n");
		}

		bw.flush();
	}

	public static int solve(int[][] s, int[][] dp, int a, int b) {
		if (dp[a][b] >= 0) {
			return dp[a][b];
		} else {
			dp[a][b] = s[a][b - 1] + Math.max(solve(s, dp, (a + 1) % 2, b - 1), solve(s, dp, (a + 1) % 2, b - 2));
			return dp[a][b];
		}
	}
}