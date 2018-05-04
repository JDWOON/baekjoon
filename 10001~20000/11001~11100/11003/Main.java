package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		int[] b = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		b[0] = a[0];

		for (int i = 1; i < l; i++) {
			b[i] = Math.min(b[i - 1], a[i]);
		}

		for (int i = 0; i < n; i += l) {
			getMin(a, b, n, l, i);
		}

		for (int i = 0; i < n; i++) {
			bw.write(b[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}

	public static void getMin(int[] a, int[] b, int n, int l, int start) {
		int[] min = new int[2 * l - 1];

		min[l - 1] = (start + l - 1 < n && start + l - 1 > -1) ? a[start + l - 1] : Integer.MAX_VALUE;

		for (int i = l; i < min.length; i++) {
			int now = start + i < n ? a[start + i] : Integer.MAX_VALUE;
			min[i] = Math.min(min[i - 1], now);
		}

		for (int i = l - 2; i > -1; i--) {
			int now = (start + i < n && start + i > -1) ? a[start + i] : Integer.MAX_VALUE;
			min[i] = Math.min(min[i + 1], now);
		}

		for (int i = 0; i < l && start + l - 1 + i < n; i++) {
			b[start + l - 1 + i] = Math.min(min[i], min[i + l - 1]);
		}
	}
}