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
		int h = Integer.parseInt(st.nextToken());

		int[][][] tmt = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < m; k++) {
					tmt[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		new Main().bfs(tmt);

		int max = 1;
		boolean fail = false;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tmt[i][j][k] == 0) {
						fail = true;
					} else {
						max = Math.max(max, tmt[i][j][k]);
					}
				}
			}
		}

		if (fail) {
			System.out.println(-1);
		} else {
			System.out.println(max - 1);
		}
	}

	public void bfs(int[][][] tmt) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < tmt.length; i++) {
			for (int j = 0; j < tmt[0].length; j++) {
				for (int k = 0; k < tmt[0][0].length; k++) {
					if (tmt[i][j][k] == 1) {
						dq.addLast(i * 10000 + j * 100 + k);
					}
				}
			}
		}

		while (!dq.isEmpty()) {
			int x = dq.getFirst() / 10000;
			int y = (dq.getFirst() / 100) % 100;
			int z = dq.getFirst() % 100;
			dq.pollFirst();

			if (x > 0 && (tmt[x - 1][y][z] == 0 || tmt[x - 1][y][z] > tmt[x][y][z] + 1)) {
				tmt[x - 1][y][z] = tmt[x][y][z] + 1;
				dq.add((x - 1) * 10000 + y * 100 + z);
			}
			if (x < tmt.length - 1 && (tmt[x + 1][y][z] == 0 || tmt[x + 1][y][z] > tmt[x][y][z] + 1)) {
				tmt[x + 1][y][z] = tmt[x][y][z] + 1;
				dq.add((x + 1) * 10000 + y * 100 + z);
			}
			if (y > 0 && (tmt[x][y - 1][z] == 0 || tmt[x][y - 1][z] > tmt[x][y][z] + 1)) {
				tmt[x][y - 1][z] = tmt[x][y][z] + 1;
				dq.add(x * 10000 + (y - 1) * 100 + z);
			}
			if (y < tmt[0].length - 1 && (tmt[x][y + 1][z] == 0 || tmt[x][y + 1][z] > tmt[x][y][z] + 1)) {
				tmt[x][y + 1][z] = tmt[x][y][z] + 1;
				dq.add(x * 10000 + (y + 1) * 100 + z);
			}
			if (z > 0 && (tmt[x][y][z - 1] == 0 || tmt[x][y][z - 1] > tmt[x][y][z] + 1)) {
				tmt[x][y][z - 1] = tmt[x][y][z] + 1;
				dq.add(x * 10000 + y * 100 + z - 1);
			}
			if (z < tmt[0][0].length - 1 && (tmt[x][y][z + 1] == 0 || tmt[x][y][z + 1] > tmt[x][y][z] + 1)) {
				tmt[x][y][z + 1] = tmt[x][y][z] + 1;
				dq.add(x * 10000 + y * 100 + z + 1);
			}
		}
	}
}