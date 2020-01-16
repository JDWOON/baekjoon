import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		int[][] p = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(n, p) + "\n");
		bw.flush();
	}

	public static int solve(int n, int[][] p) {
		int[][] dp = new int[n][n];

		return getDP(p, dp, 0, n - 1);
	}

	public static int getDP(int[][] p, int[][] dp, int start, int end) {
		if (dp[start][end] > 0) {
			return dp[start][end];
		} else if (start == end) {
			return 0;
		} else {
			int minVal = Integer.MAX_VALUE;

			for (int i = start; i < end; i++) {
				int temp = getDP(p, dp, start, i) + getDP(p, dp, i + 1, end);
				temp += p[start][0] * p[i][1] * p[end][1];
				minVal = Math.min(minVal, temp);
			}

			dp[start][end] = minVal;
			return dp[start][end];
		}
	}
}
