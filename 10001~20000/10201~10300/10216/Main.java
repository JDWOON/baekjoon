package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine().trim());

			int[] pos = new int[n];
			int[] r = new int[n];

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pos[j] = x * 10000 + y;
				r[j] = Integer.parseInt(st.nextToken());
			}

			boolean[] visit = new boolean[n];
			Arrays.fill(visit, false);

			int cnt = 0;
			for (int j = 0; j < n; j++) {
				cnt += new Main().dfs(pos, r, visit, j);
			}

			System.out.println(cnt);
		}
	}

	public int dfs(int[] pos, int[] r, boolean[] visit, int now) {
		if (visit[now]) {
			return 0;
		} else {
			visit[now] = true;
			int x = pos[now] / 10000;
			int y = pos[now] % 10000;
			for (int i = 0; i < pos.length; i++) {
				int xlen = x - pos[i] / 10000;
				int ylen = y - pos[i] % 10000;
				if (!visit[i] && xlen * xlen + ylen * ylen <= (r[now] + r[i]) * (r[now] + r[i])) {
					dfs(pos, r, visit, i);
				}
			}
			return 1;
		}
	}
}