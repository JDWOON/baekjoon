import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[] p = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			p[i] = Long.parseLong(st.nextToken());
		}

		bw.write(solve(p) + "");

		bw.flush();
	}

	public static long solve(long[] p) {
		long max = 0;

		for (int i = 0; i < p.length; i++) {
			int cnt = 0;

			for (int left = i - 1; left >= 0; left--) {
				boolean check = true;
				long len = i - left;

				for (int k = left + 1; k < i; k++) {
					long a = k - left;
					long b = i - k;
					if (p[left] * b + p[i] * a <= p[k] * len) {
						check = false;
						break;
					}
				}

				if (check) {
					cnt++;
				}
			}

			for (int right = i + 1; right < p.length; right++) {
				boolean check = true;
				long len = right - i;

				for (int k = i + 1; k < right; k++) {
					long a = k - i;
					long b = right - k;
					if (p[i] * b + p[right] * a <= p[k] * len) {
						check = false;
						break;
					}
				}

				if (check) {
					cnt++;
				}
			}

			if (cnt > max) {
				max = cnt;
			}
		}

		return max;
	}
}