import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[223];

		for (int i = 1; i <= 223; i++) {
			arr[i - 1] = i * i;
		}

		int[] dp = new int[50001];

		for (int i = 0; i < dp.length; i++) {
			for (int val : arr) {
				if (i + val < dp.length) {
					if (dp[i + val] == 0 || dp[i + val] > dp[i] + 1) {
						dp[i + val] = dp[i] + 1;
					}
				}
			}
		}

		int n = Integer.parseInt(br.readLine());

		bw.write(dp[n] + "\n");

		bw.flush();
	}
}