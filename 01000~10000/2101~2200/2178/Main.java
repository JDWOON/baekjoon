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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		new Main().bfs(map);
		System.out.println(map[n - 1][m - 1]);
	}

	public void bfs(int[][] map) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.addLast(0);
		boolean[][] visit = new boolean[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				visit[i][j] = false;
			}
		}

		while (!dq.isEmpty()) {
			int x = dq.peek() / 100;
			int y = dq.peek() % 100;
			dq.pollFirst();

			if (!visit[x][y]) {
				if (x > 0 && (map[x - 1][y] == 1 || map[x - 1][y] > map[x][y])) {
					map[x - 1][y] = map[x][y] + 1;
					dq.addLast((x - 1) * 100 + y);
				}
				if (x < map.length - 1 && (map[x + 1][y] == 1 || map[x + 1][y] > map[x][y])) {
					map[x + 1][y] = map[x][y] + 1;
					dq.addLast((x + 1) * 100 + y);
				}

				if (y > 0 && (map[x][y - 1] == 1 || map[x][y - 1] > map[x][y])) {
					map[x][y - 1] = map[x][y] + 1;
					dq.addLast(x * 100 + y - 1);
				}
				if (y < map[0].length - 1 && (map[x][y + 1] == 1 || map[x][y + 1] > map[x][y])) {
					map[x][y + 1] = map[x][y] + 1;
					dq.addLast(x * 100 + y + 1);
				}
			}

			visit[x][y] = true;
		}
	}
}