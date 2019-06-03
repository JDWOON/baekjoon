import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Integer>[] list;
	public static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 1;

		bw.write((n % 2 == 0 ? solve(dp, n) : 0) + "");

		bw.flush();
	}

	public static int solve(int[] dp, int n) {
		if (n % 2 == 1) {
			return 0;
		} else if (dp[n] > 0) {
			return dp[n];
		} else {
			dp[n] = solve(dp, n - 2) * 3;

			for (int i = 0; i <= n - 4; i += 2) {
				dp[n] += solve(dp, i) * 2;
			}

			return dp[n];
		}
	}
}