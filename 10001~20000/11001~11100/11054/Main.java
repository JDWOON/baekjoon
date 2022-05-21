import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				} else if (arr[i] == arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]);
				}

				if (arr[n - 1 - i] > arr[n - 1 - j]) {
					dp[n - 1 - i][1] = Math.max(dp[n - 1 - i][1], dp[n - 1 - j][1] + 1);
				} else if (arr[n - 1 - i] == arr[n - 1 - j]) {
					dp[n - 1 - i][1] = Math.max(dp[n - 1 - i][1], dp[n - 1 - j][1]);
				}
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i][0] + dp[i][1] + 1);
		}

		bw.write(result + "\n");

		bw.flush();
	}
}