package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] p = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				p[i][j] = ' ';
			}
		}

		new Main().solve(p, n, 0, 0);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(p[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public void solve(char[][] p, int len, int x, int y) {
		if (len == 1) {
			p[x][y] = '*';
		} else {
			int next = len / 3;
			solve(p, next, x, y);
			solve(p, next, x + next, y);
			solve(p, next, x + next * 2, y);
			solve(p, next, x, y + next);
			solve(p, next, x + next * 2, y + next);
			solve(p, next, x, y + next * 2);
			solve(p, next, x + next, y + next * 2);
			solve(p, next, x + next * 2, y + next * 2);
		}
	}
}