import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int SIZE = 2, EAT = 0;
	public static int X, Y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					X = i;
					Y = j;
				}
			}
		}

		bw.write(solve(map, n) + "\n");

		bw.flush();
	}

	public static int solve(int[][] map, int n) {
		Position next = getNext(map, n);
		int result = 0;
		while (next != null) {
			result += next.d;

			map[X][Y] = 0;

			X = next.x;
			Y = next.y;
			map[X][Y] = 9;

			EAT++;
			if (EAT == SIZE) {
				SIZE++;
				EAT = 0;
			}

			next = getNext(map, n);
		}

		return result;
	}

	public static Position getNext(int[][] map, int n) {
		LinkedList<Position> queue = new LinkedList<Position>();
		queue.add(new Position(X, Y, 0));

		boolean[][] isVisit = new boolean[n][n];

		Position next = null;

		while (!queue.isEmpty()) {
			Position now = queue.poll();

			if (!isVisit[now.x][now.y]) {
				if (next != null && now.d > next.d) {
					break;
				}

				if (map[now.x][now.y] > 0 && map[now.x][now.y] < 7 && map[now.x][now.y] < SIZE) {
					if (next == null || next.x > now.x || (next.x == now.x && next.y > now.y)) {
						next = now;
					}
				}

				isVisit[now.x][now.y] = true;

				if (next == null && (map[now.x][now.y] <= SIZE || map[now.x][now.y] == 9)) {
					if (now.x > 0) {
						queue.add(new Position(now.x - 1, now.y, now.d + 1));
					}
					if (now.y > 0) {
						queue.add(new Position(now.x, now.y - 1, now.d + 1));
					}
					if (now.y < n - 1) {
						queue.add(new Position(now.x, now.y + 1, now.d + 1));
					}
					if (now.x < n - 1) {
						queue.add(new Position(now.x + 1, now.y, now.d + 1));
					}
				}
			}
		}

		return next;
	}

	public static class Position {
		int x, y, d;

		public Position(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}