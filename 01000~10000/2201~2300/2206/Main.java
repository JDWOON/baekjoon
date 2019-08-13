import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = (int) (temp.charAt(j) - '0');
			}
		}

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static int solve() {
		boolean[][][] check = new boolean[2][n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(check[0][i], false);
			Arrays.fill(check[1][i], false);
		}

		Queue<Status> st = new LinkedList<Status>();
		st.add(new Status(0, 0, 1, false));

		while (!st.isEmpty()) {
			Status now = st.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				return now.cnt;
			}

			if (now.destory && !check[0][now.x][now.y] && !check[1][now.x][now.y]) {
				check[1][now.x][now.y] = true;

				if (now.x > 0) {
					if (map[now.x - 1][now.y] == 0 && !check[0][now.x - 1][now.y] && !check[1][now.x - 1][now.y]) {
						st.add(new Status(now.x - 1, now.y, now.cnt + 1, now.destory));
					}
				}

				if (now.x < n - 1) {
					if (map[now.x + 1][now.y] == 0 && !check[0][now.x + 1][now.y] && !check[1][now.x + 1][now.y]) {
						st.add(new Status(now.x + 1, now.y, now.cnt + 1, now.destory));
					}
				}

				if (now.y > 0) {
					if (map[now.x][now.y - 1] == 0 && !check[0][now.x][now.y - 1] && !check[1][now.x][now.y - 1]) {
						st.add(new Status(now.x, now.y - 1, now.cnt + 1, now.destory));
					}
				}

				if (now.y < m - 1) {
					if (map[now.x][now.y + 1] == 0 && !check[0][now.x][now.y + 1] && !check[1][now.x][now.y + 1]) {
						st.add(new Status(now.x, now.y + 1, now.cnt + 1, now.destory));
					}
				}
			} else if (!now.destory && !check[0][now.x][now.y]) {
				check[0][now.x][now.y] = true;

				if (now.x > 0) {
					if (map[now.x - 1][now.y] == 0 && !check[0][now.x - 1][now.y]) {
						st.add(new Status(now.x - 1, now.y, now.cnt + 1, now.destory));
					} else if (map[now.x - 1][now.y] == 1 && !check[0][now.x - 1][now.y]) {
						st.add(new Status(now.x - 1, now.y, now.cnt + 1, true));
					}
				}

				if (now.x < n - 1) {
					if (map[now.x + 1][now.y] == 0 && !check[0][now.x + 1][now.y]) {
						st.add(new Status(now.x + 1, now.y, now.cnt + 1, now.destory));
					} else if (map[now.x + 1][now.y] == 1 && !check[0][now.x + 1][now.y]) {
						st.add(new Status(now.x + 1, now.y, now.cnt + 1, true));
					}
				}

				if (now.y > 0) {
					if (map[now.x][now.y - 1] == 0 && !check[0][now.x][now.y - 1]) {
						st.add(new Status(now.x, now.y - 1, now.cnt + 1, now.destory));
					} else if (map[now.x][now.y - 1] == 1 && !check[0][now.x][now.y - 1]) {
						st.add(new Status(now.x, now.y - 1, now.cnt + 1, true));
					}
				}

				if (now.y < m - 1) {
					if (map[now.x][now.y + 1] == 0 && !check[0][now.x][now.y + 1]) {
						st.add(new Status(now.x, now.y + 1, now.cnt + 1, now.destory));
					} else if (map[now.x][now.y + 1] == 1 && !check[0][now.x][now.y + 1]) {
						st.add(new Status(now.x, now.y + 1, now.cnt + 1, true));
					}
				}
			}

		}

		return -1;
	}

	public static class Status {
		int x, y, cnt;
		boolean destory;

		Status(int x, int y, int cnt, boolean destroy) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destory = destroy;
		}
	}
}
