import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int n;
	private static int list[][];
	private static int dp[][];

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		list = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				list[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static int solve() {
		dp = new int[1 << (n + 1)][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = 20;
			}
		}
		dp[1][0] = 0;
		makeDP(0, 1);

		int result = 1;

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] < 10) {
					if (result < getCount(i)) {
						result = getCount(i);
					}
				}
			}
		}

		return result;
	}

	public static void makeDP(int now, int val) {
		for (int i = 0; i < n; i++) {
			if (!isVisit(val, i)) {
				int nextVal = val | (1 << i);
				if (dp[val][now] <= list[now][i] && dp[nextVal][i] > list[now][i]) {
					dp[nextVal][i] = list[now][i];
					makeDP(i, nextVal);
				}
			}
		}
	}

	public static boolean isVisit(int val, int now) {
		return (val & (1 << now)) > 0;
	}

	public static int getCount(int now) {
		int result = 0;
		while (now > 0) {
			result += now % 2;
			now /= 2;
		}
		return result;
	}
}