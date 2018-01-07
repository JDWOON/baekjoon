package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '0') {
					map[i][j] = 0;
				} else {
					map[i][j] = -1;
				}
			}
		}

		int[] cnt = new int[n * n];
		Arrays.fill(cnt, 0);
		int total = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] < 0) {
					new Main().dfs(map, cnt, total, i, j);
					total++;
				}
			}
		}
		cnt = Arrays.copyOf(cnt, total);
		Arrays.sort(cnt);

		System.out.println(total);
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}

	public void dfs(int[][] map, int[] cnt, int num, int x, int y) {
		if (map[x][y] < 0) {
			cnt[num]++;
			map[x][y] = num;
			if (x > 0) {
				dfs(map, cnt, num, x - 1, y);
			}
			if (y > 0) {
				dfs(map, cnt, num, x, y - 1);
			}
			if (x < map.length - 1) {
				dfs(map, cnt, num, x + 1, y);
			}
			if (y < map[0].length - 1) {
				dfs(map, cnt, num, x, y + 1);
			}
		}
	}
}