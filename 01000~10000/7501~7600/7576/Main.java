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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] tmt = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				tmt[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		new Main().bfs(tmt);

		int max = 1;
		boolean fail = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmt[i][j] == 0) {
					fail = true;
				} else {
					max = Math.max(max, tmt[i][j]);
				}
			}
		}

		if (fail) {
			System.out.println(-1);
		} else {
			System.out.println(max - 1);
		}
	}

	public void bfs(int[][] tmt) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < tmt.length; i++) {
			for (int j = 0; j < tmt[0].length; j++) {
				if (tmt[i][j] == 1) {
					dq.addLast(i * 1000 + j);
				}
			}
		}

		while (!dq.isEmpty()) {
			int x = dq.getFirst() / 1000;
			int y = dq.getFirst() % 1000;
			dq.pollFirst();

			if (x > 0 && (tmt[x - 1][y] == 0 || tmt[x - 1][y] > tmt[x][y] + 1)) {
				tmt[x - 1][y] = tmt[x][y] + 1;
				dq.add((x - 1) * 1000 + y);
			}
			if (x < tmt.length - 1 && (tmt[x + 1][y] == 0 || tmt[x + 1][y] > tmt[x][y] + 1)) {
				tmt[x + 1][y] = tmt[x][y] + 1;
				dq.add((x + 1) * 1000 + y);
			}
			if (y > 0 && (tmt[x][y - 1] == 0 || tmt[x][y - 1] > tmt[x][y] + 1)) {
				tmt[x][y - 1] = tmt[x][y] + 1;
				dq.add(x * 1000 + y - 1);
			}
			if (y < tmt[0].length - 1 && (tmt[x][y + 1] == 0 || tmt[x][y + 1] > tmt[x][y] + 1)) {
				tmt[x][y + 1] = tmt[x][y] + 1;
				dq.add(x * 1000 + y + 1);
			}
		}
	}
}