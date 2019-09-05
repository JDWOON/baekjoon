import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] lab;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		lab = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(solve() + "\n");

		bw.flush();
	}

	public static int solve() {
		ArrayList<Dot> list = new ArrayList<Dot>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lab[i][j] == 0) {
					list.add(new Dot(i, j));
				}
			}
		}

		int result = 0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				for (int k = j + 1; k < list.size(); k++) {
					int[][] now = copyMap(lab);
					now[list.get(i).r][list.get(i).c] = 1;
					now[list.get(j).r][list.get(j).c] = 1;
					now[list.get(k).r][list.get(k).c] = 1;

					result = Math.max(result, getSafeArea(now));
				}
			}
		}

		return result;
	}

	public static int[][] copyMap(int[][] map) {
		int[][] now = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				now[i][j] = map[i][j];
			}
		}

		return now;
	}

	public static int getSafeArea(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					dfs(map, i, j);
				}
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					result++;
				}
			}
		}

		return result;
	}

	public static void dfs(int[][] map, int r, int c) {
		if (map[r][c] == 2) {
			if (r > 0 && map[r - 1][c] == 0) {
				map[r - 1][c] = 2;
				dfs(map, r - 1, c);
			}

			if (r < n - 1 && map[r + 1][c] == 0) {
				map[r + 1][c] = 2;
				dfs(map, r + 1, c);
			}

			if (c > 0 && map[r][c - 1] == 0) {
				map[r][c - 1] = 2;
				dfs(map, r, c - 1);
			}

			if (c < m - 1 && map[r][c + 1] == 0) {
				map[r][c + 1] = 2;
				dfs(map, r, c + 1);
			}
		}
	}

	public static class Dot {
		int r, c;

		Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}