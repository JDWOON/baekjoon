package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] hope = new boolean[n][m + 1];
		boolean[] isIn = new boolean[m + 1];

		// init
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m + 1; j++) {
				hope[i][j] = false;
			}
		}

		// input data
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int si = Integer.parseInt(st.nextToken());
			for (int j = 0; j < si; j++) {
				int temp = Integer.parseInt(st.nextToken());
				hope[i][temp] = true;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solve(hope, isIn, n, m) + "");
		bw.flush();
	}

	public static int solve(boolean[][] hope, boolean[] isIn, int n, int m) {
		int[] cow = new int[n];
		int[] home = new int[m + 1];
		int cnt = 0;

		for (int i = 0; i < cow.length; i++) {
			cow[i] = -1;
		}

		for (int i = 0; i < home.length; i++) {
			home[i] = -1;
		}
		
		for(int i=0; i<n; i++) {
			for (int j = 0; j < isIn.length; j++) {
				isIn[j] = false;
			}
			
			if(dfs(hope, isIn, cow, home, i)) {
				cnt++;
			}
		}

		return cnt;
	}

	public static boolean dfs(boolean[][] hope, boolean[] isIn, int[] cow, int[] home, int a) {
		if (isIn[a]) {
			return false;
		} else {
			isIn[a] = true;

			for (int b = 0; b < home.length; b++) {
				if (hope[a][b]) {
					if (home[b] == -1 || dfs(hope, isIn, cow, home, home[b])) {
						cow[a] = b;
						home[b] = a;

						return true;
					}
				}
			}
		}
		
		return false;
	}
}