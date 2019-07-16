import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long[] trees = new long[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(trees);

		long[] sum = new long[n];
		sum[n - 1] = 0;
		for (int i = n - 2; i > -1; i--) {
			sum[i] = (n - i - 1) * (trees[i + 1] - trees[i]) + sum[i + 1];
		}

		long right = 0, left = 0, mid = 0;
		int tLen = 0;

		for (int i = 0; i < n; i++) {
			if (sum[i] <= m) {
				right = trees[i];
				left = i == 0 ? 0 : trees[i - 1];
				mid = right;
				tLen = n - i;
				m -= sum[i];
				break;
			}
		}

		while (m > 0) {
			mid = (right + left) / 2;
			if ((right - mid) * tLen > m) {
				left = mid;
			} else {
				m -= (right - mid) * tLen;
				right = mid;
			}

			if (right - left <= 1) {
				if (m > 0) {
					mid = left;
				} else {
					mid = right;
				}
				break;
			}
		}

		bw.write(mid + "\n");
		bw.flush();
	}
}
