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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Bag[] list = new Bag[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[i] = new Bag(w, v);
		}

		bw.write(solve(n, k, list) + "\n");
		bw.flush();
	}

	public static int solve(int n, int k, Bag[] list) {
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < k + 1; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

				if (j >= list[i - 1].w) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - list[i - 1].w] + list[i - 1].v);
				}
			}
		}

		return dp[n][k];
	}

	static class Bag {
		int w;
		int v;

		Bag(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}
