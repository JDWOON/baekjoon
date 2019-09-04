import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r, c, t;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < t; i++) {
			map = spread(map);
			map = airCleaner(map);
		}

		bw.write(dust(map) + "\n");

		bw.flush();
	}

	public static int dust(int[][] now) {
		int result = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += now[i][j] > 0 ? now[i][j] : 0;
			}
		}

		return result;
	}

	public static int[][] airCleaner(int[][] now) {
		int airTop = -1, airBot = -1;

		for (int i = 0; i < r; i++) {
			if (now[i][0] == -1) {
				airTop = i;
				airBot = i + 1;
				break;
			}
		}

		int[][] result = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = now[i][j];
			}
		}

		for (int i = airTop - 1; i > 0; i--) {
			result[i][0] = result[i - 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			result[0][i] = result[0][i + 1];
		}
		for (int i = 0; i < airTop; i++) {
			result[i][c - 1] = result[i + 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			result[airTop][i] = result[airTop][i - 1];
		}
		result[airTop][1] = 0;

		for (int i = airBot + 1; i < r - 1; i++) {
			result[i][0] = result[i + 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			result[r - 1][i] = result[r - 1][i + 1];
		}
		for (int i = r - 1; i > airBot - 1; i--) {
			result[i][c - 1] = result[i - 1][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			result[airBot][i] = result[airBot][i - 1];
		}
		result[airBot][1] = 0;

		return result;
	}

	public static int[][] spread(int[][] now) {
		int[][] result = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int temp = now[i][j];

				if (i > 0 && now[i - 1][j] != -1) {
					result[i - 1][j] += now[i][j] / 5;
					temp -= now[i][j] / 5;
				}

				if (i < r - 1 && now[i + 1][j] != -1) {
					result[i + 1][j] += now[i][j] / 5;
					temp -= now[i][j] / 5;
				}

				if (j > 0 && now[i][j - 1] != -1) {
					result[i][j - 1] += now[i][j] / 5;
					temp -= now[i][j] / 5;
				}

				if (j < c - 1 && now[i][j + 1] != -1) {
					result[i][j + 1] += now[i][j] / 5;
					temp -= now[i][j] / 5;
				}

				result[i][j] += temp;
			}
		}

		return result;
	}
}
