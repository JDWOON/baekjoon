import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(solve(map, n, m) + "\n");

		bw.flush();
	}

	public static int solve(int[][] map, int n, int m) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result = Math.max(result, getVal(map, n, m, i, j));
			}
		}

		return result;
	}

	public static int getVal(int[][] map, int n, int m, int x, int y) {
		int result = 0;

		if (x + 3 < n) {
			int temp = 0;

			for (int i = 0; i <= 3; i++) {
				temp += map[x + i][y];
			}

			result = Math.max(result, temp);
		}

		if (y + 3 < m) {
			int temp = 0;

			for (int i = 0; i <= 3; i++) {
				temp += map[x][y + i];
			}

			result = Math.max(result, temp);
		}

		if (x + 2 < n && y + 1 < m) {
			int temp = 0;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 1; j++) {
					temp += map[x + i][y + j];
				}
			}
			result = Math.max(result, temp - map[x][y] - map[x][y + 1]);
			result = Math.max(result, temp - map[x + 2][y] - map[x + 2][y + 1]);

			result = Math.max(result, temp - map[x][y] - map[x + 1][y]);
			result = Math.max(result, temp - map[x][y + 1] - map[x + 1][y + 1]);
			result = Math.max(result, temp - map[x + 1][y] - map[x + 2][y]);
			result = Math.max(result, temp - map[x + 1][y + 1] - map[x + 2][y + 1]);

			result = Math.max(result, temp - map[x][y] - map[x + 2][y + 1]);
			result = Math.max(result, temp - map[x][y + 1] - map[x + 2][y]);

			result = Math.max(result, temp - map[x][y] - map[x + 2][y]);
			result = Math.max(result, temp - map[x][y + 1] - map[x + 2][y + 1]);
		}

		if (x + 1 < n && y + 2 < m) {
			int temp = 0;
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j <= 2; j++) {
					temp += map[x + i][y + j];
				}
			}
			result = Math.max(result, temp - map[x][y] - map[x + 1][y]);
			result = Math.max(result, temp - map[x][y + 2] - map[x + 1][y + 2]);

			result = Math.max(result, temp - map[x][y] - map[x][y + 1]);
			result = Math.max(result, temp - map[x][y + 1] - map[x][y + 2]);
			result = Math.max(result, temp - map[x + 1][y] - map[x + 1][y + 1]);
			result = Math.max(result, temp - map[x + 1][y + 1] - map[x + 1][y + 2]);

			result = Math.max(result, temp - map[x][y] - map[x + 1][y + 2]);
			result = Math.max(result, temp - map[x + 1][y] - map[x][y + 2]);

			result = Math.max(result, temp - map[x][y] - map[x][y + 2]);
			result = Math.max(result, temp - map[x + 1][y] - map[x + 1][y + 2]);
		}

		return result;
	}
}