import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = 100;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> move = new HashMap<Integer, Integer>();

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			move.put(x, y);
		}

		int[] dp = new int[MAX];

		search(move, dp, 1, 0);

		bw.write(solve(move, dp) + "\n");

		bw.flush();
	}

	public static void search(HashMap<Integer, Integer> move, int[] dp, int now, int cnt) {
		if (move.containsKey(now)) {
			now = move.get(now);
		}

		if (dp[now] == 0 || dp[now] > cnt) {
			dp[now] = cnt;

			for (int i = 1; i <= 6 && now + i < MAX; i++) {
				search(move, dp, now + i, cnt + 1);
			}
		}
	}

	public static int solve(HashMap<Integer, Integer> move, int[] dp) {
		int result = Integer.MAX_VALUE;

		for (int i = 1; i <= 6; i++) {
			if (!move.containsKey(MAX - i)) {
				result = Math.min(result, dp[MAX - i]);
			}
		}

		return result + 1;
	}
}