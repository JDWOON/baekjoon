import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(map, n, m, t);
		bw.flush();
	}

	public static void solve(int[][] map, int n, int m, int t) throws IOException {
		int[][] path = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(path[i], Integer.MAX_VALUE);
		}

		setPath(map, path, 0, 0, 0);

		int gx = -1, gy = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					gx = i;
					gy = j;
				}
			}
		}

		int result = Integer.MAX_VALUE;

		if (path[gx][gy] != Integer.MAX_VALUE) {
			result = path[gx][gy] + (n - gx - 1) + (m - gy - 1);
		}

		result = Math.min(result, path[n - 1][m - 1]);

		if (result > t) {
			bw.write("Fail");
		} else {
			bw.write(result + "\n");
		}
	}

	public static void setPath(int[][] map, int[][] path, int x, int y, int now) {
		if (path[x][y] > now) {
			path[x][y] = now;

			if (x > 0 && path[x - 1][y] > now && map[x - 1][y] != 1) {
				setPath(map, path, x - 1, y, now + 1);
			}
			if (x < map.length - 1 && path[x + 1][y] > now && map[x + 1][y] != 1) {
				setPath(map, path, x + 1, y, now + 1);
			}
			if (y > 0 && path[x][y - 1] > now && map[x][y - 1] != 1) {
				setPath(map, path, x, y - 1, now + 1);
			}
			if (y < map[0].length - 1 && path[x][y + 1] > now && map[x][y + 1] != 1) {
				setPath(map, path, x, y + 1, now + 1);
			}
		}
	}
}