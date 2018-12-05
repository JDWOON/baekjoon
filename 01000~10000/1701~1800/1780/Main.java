package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] p = new int[n][n];
		int[] cnt = { 0, 0, 0 };

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int idx = 0;
			for (int j = 0; j < n; j++) {
				if (s.charAt(idx) == '0') {
					p[i][j] = 0;
					idx += 2;
				} else if (s.charAt(idx) == '1') {
					p[i][j] = 1;
					idx += 2;
				} else {
					p[i][j] = -1;
					idx += 3;
				}
			}
		}

		for (int len = n; len > 0; len /= 3) {
			for (int i = 0; i < n; i += len) {
				for (int j = 0; j < n; j += len) {
					if (p[i][j] == 0 || p[i][j] == 1 || p[i][j] == -1) {
						boolean check = true;

						for (int a = 0; a < len && check; a++) {
							for (int b = 0; b < len && check; b++) {
								if (p[i][j] != p[i + a][j + b]) {
									check = false;
								}
							}
						}

						if (check) {
							cnt[p[i][j] + 1]++;
							for (int a = 0; a < len; a++) {
								for (int b = 0; b < len; b++) {
									p[i + a][j + b] = -2;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}
}