import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	static int n;
	static long k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		bw.write(solve() + "\n");

		bw.flush();
	}

	public static String solve() {
		dp = new long[n + 1][n + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		if (k >= pow(2, n) - getDP(0, 0)) {
			return "-1";
		}

		String result = new String();
		int cnt = 0;
		long temp = 0;

		for (int i = 0; i < n; i++) {
			long left = cnt < 0 || cnt > n ? pow(2, n - i - 1) : pow(2, n - i - 1) - getDP(i + 1, cnt + 1);
			if (temp + left > k) {
				result += "(";
				if (cnt >= 0 && cnt <= n) {
					cnt++;
				}
			} else {
				result += ")";
				temp += left;
				if (cnt >= 0 && cnt <= n) {
					cnt--;
				}
			}
		}

		return result;
	}

	public static long getDP(int now, int cnt) {
		if (cnt < 0 || cnt > n) {
			return 0;
		} else if (dp[now][cnt] == -1) {
			if (n - now == cnt) {
				dp[now][cnt] = 1;
			} else if (n - now < cnt) {
				dp[now][cnt] = 0;
			} else {
				dp[now][cnt] = getDP(now + 1, cnt + 1) + getDP(now + 1, cnt - 1);
			}
		}

		return dp[now][cnt];
	}

	public static long pow(int a, int b) {
		long result = 1;
		for (int i = 0; i < b; i++) {
			result *= (long) a;
		}
		return result;
	}
}
