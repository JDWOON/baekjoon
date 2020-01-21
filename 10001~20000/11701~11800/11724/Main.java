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

		boolean[][] p = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(p[i], false);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			p[a][b] = true;
			p[b][a] = true;
		}

		bw.write(solve(n, p) + "\n");
		bw.flush();
	}

	public static int solve(int n, boolean[][] p) {
		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);

		int result = 0;

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				dfs(n, p, visit, i);
				result++;
			}
		}

		return result;
	}

	public static void dfs(int n, boolean[][] p, boolean[] visit, int now) {
		for (int i = 0; i < n; i++) {
			if (!visit[i] && p[now][i]) {
				visit[i] = true;
				dfs(n, p, visit, i);
			}
		}
	}
}
