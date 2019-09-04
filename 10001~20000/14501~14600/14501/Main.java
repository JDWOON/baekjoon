import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] t = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(n, t, p) + "\n");
		bw.flush();
	}

	public static int solve(int n, int[] t, int[] p) {
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = i + t[i]; j < n + 1; j++) {
				dp[j] = Math.max(dp[j], dp[i] + p[i]);
			}
		}

		return dp[n];
	}
}
