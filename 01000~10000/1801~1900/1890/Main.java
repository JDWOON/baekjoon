package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] cnt = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt[i][j] = 0;
			}
		}
		cnt[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int val = map[i][j];
				if (val > 0) {
					if (i + val < n) {
						cnt[i + val][j] += cnt[i][j];
					}
					if (j + val < n) {
						cnt[i][j + val] += cnt[i][j];
					}
				}
			}
		}

		System.out.println(cnt[n - 1][n - 1]);
	}
}