package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int line = Integer.parseInt(br.readLine().trim());
		boolean[][] con = new boolean[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(con[i], false);
		}

		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			con[a][b] = true;
			con[b][a] = true;
		}

		boolean[] virus = new boolean[n + 1];
		Arrays.fill(virus, false);
		new Main().dfs(virus, con, 1);

		int cnt = 0;

		for (int i = 1; i < n + 1; i++) {
			if (virus[i]) {
				cnt++;
			}
		}

		System.out.println(cnt - 1);
	}

	public void dfs(boolean[] virus, boolean[][] con, int now) {
		virus[now] = true;
		for (int i = 1; i < con[now].length; i++) {
			if (con[now][i] && !virus[i]) {
				dfs(virus, con, i);
			}
		}
	}
}