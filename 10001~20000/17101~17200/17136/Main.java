import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static final int fail = 17;
	public static int minCnt;
	public static int[][] map;
	public static int[] paper = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static int solve() {
		Arrays.fill(paper, 5);
		int totalArea = 0;
		minCnt = fail;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] > 0) {
					totalArea++;
				}
			}
		}

		int result = dfs(0, totalArea, 0);

		return result == fail ? -1 : result;
	}

	public static int dfs(int now, int nowArea, int idx) {
		if (minCnt <= now) {
			return minCnt;
		}

		int maxSize = 0;

		for (int i = Math.min(getMax(), 5); i > 0; i--) {
			if (paper[i] > 0) {
				maxSize = i;
				break;
			}
		}

		if (maxSize == 0) {
			if (nowArea == 0) {
				minCnt = now;
				return now;
			} else {
				return fail;
			}
		} else if (maxSize == 1) {
			if (nowArea <= paper[1]) {
				now += nowArea;
				minCnt = Math.min(minCnt, now);
				return now;
			} else {
				return fail;
			}
		} else {
			int r = idx / 10;
			int c = idx % 10;

			if (map[r][c] == 0) {
				return dfs(now, nowArea, idx + 1);
			} else {
				int result = minCnt;

				for (int size = Math.min(map[r][c], maxSize); size > 0; size--) {
					if (paper[size] > 0) {
						paper[size]--;
						attach(r, c, size, 0);
						result = Math.min(result, dfs(now + 1, nowArea - (size * size), idx + 1));
						attach(r, c, size, 1);
						paper[size]++;
					}
				}

				return result;
			}
		}
	}

	public static int getMax() {
		int result = 0;

		for (int i = 9; i > -1; i--) {
			for (int j = 9; j > -1; j--) {
				if (i == 9 || j == 9) {
					map[i][j] = Math.min(map[i][j], 1);
				} else if (map[i][j] > 0) {
					map[i][j] = Math.min(map[i + 1][j], map[i][j + 1]);
					map[i][j] = Math.min(map[i][j], map[i + 1][j + 1]);
					map[i][j]++;
				}

				result = Math.max(result, map[i][j]);
			}
		}

		return result;
	}

	public static void attach(int r, int c, int size, int op) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[r + i][c + j] = op;
			}
		}
	}
}