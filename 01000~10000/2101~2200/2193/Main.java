import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][2];

		bw.write(solve(dp, n) + "\n");
		bw.flush();
	}

	public static long solve(long[][] dp, int n) {
		if (n == 1) {
			return 1;
		} else if (dp[n][0] > 0) {
			return dp[n][0] + dp[n][1];
		} else {
			dp[n][0] = solve(dp, n - 1);
			dp[n][1] = dp[n - 1][0];

			return dp[n][0] + dp[n][1];
		}
	}

}
