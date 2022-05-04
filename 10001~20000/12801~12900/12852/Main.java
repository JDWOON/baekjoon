import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static int MAX = 1000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dp = new int[MAX];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 1; i < MAX; i++) {
			int[] next = { i + 1, i * 2, i * 3 };

			for (int temp : next) {
				if (temp < MAX && (dp[temp] == 0 || dp[temp] > dp[i] + 1)) {
					dp[temp] = dp[i] + 1;
					map.put(temp, i);
				}
			}
		}

		int n = Integer.parseInt(br.readLine());

		bw.write(dp[n] + "\n");

		while (n > 1) {
			bw.write(n + " ");
			n = map.get(n);
		}

		bw.write("1\n");

		bw.flush();
	}
}
