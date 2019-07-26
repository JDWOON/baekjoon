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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(a) + "\n");
		bw.flush();
	}

	public static int solve(int[] a) {
		int[] dp = new int[a.length];
		int max = 1;

		for (int i = 0; i < a.length; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}
}
