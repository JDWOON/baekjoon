import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[1000001];
		Arrays.fill(dp, -1);

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (dp[a[i] - 1] == -1) {
				dp[a[i]] = 1;
			} else {
				dp[a[i]] = dp[a[i] - 1] + 1;
			}
			max = Math.max(max, dp[a[i]]);
		}

		System.out.println(max);
	}
}