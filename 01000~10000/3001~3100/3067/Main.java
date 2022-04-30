import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] coin = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());

			bw.write(solve(coin, m) + "\n");
		}

		bw.flush();
	}

	public static int solve(int[] coin, int m) {
		int[] cal = new int[m + 1];
		cal[0] = 1;

		for (int i = 0; i < coin.length; i++) {
			for (int j = 1; j <= m; j++) {
				if (coin[i] <= j) {
					cal[j] = cal[j] + cal[j - coin[i]];
				}
			}
		}

		return cal[m];
	}
}
