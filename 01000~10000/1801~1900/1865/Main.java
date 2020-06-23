import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			for (int j = 0; j < n; j++) {
				Arrays.fill(map[j], Integer.MAX_VALUE);
			}

			ArrayList<Integer>[] list = new ArrayList[n];
			for (int j = 0; j < n; j++) {
				list[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int t = Integer.parseInt(st.nextToken());
				map[s][e] = Math.min(map[s][e], t);
				map[e][s] = Math.min(map[e][s], t);
			}

			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int t = 0 - Integer.parseInt(st.nextToken());
				map[s][e] = Math.min(map[s][e], t);
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] != Integer.MAX_VALUE) {
						list[j].add(k * 50000 + map[j][k] + 10000);
					}
				}
			}

			bw.write(solve(list, n) + "\n");
		}

		bw.flush();

	}

	public static String solve(ArrayList<Integer>[] list, int n) {
		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);

		int[] check = new int[n];
		Arrays.fill(check, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				check[i] = 0;
				dfs(list, new ArrayList<Integer>(), visit, check, n, i, 0);
			}
		}

		for (int i = 0; i < n; i++) {
			if (check[i] == Integer.MIN_VALUE) {
				return "YES";
			}
		}

		return "NO";
	}

	public static void dfs(ArrayList<Integer>[] list, ArrayList<Integer> path, boolean[] visit, int[] check, int n,
			int now, int cnt) {
		visit[now] = true;

		path.add(now);

		for (int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i) / 50000;
			int weight = (list[now].get(i) % 50000) - 10000;

			if (check[now] + weight < check[next]) {
				if (cnt > n) {
					check[next] = Integer.MIN_VALUE;
				} else {
					check[next] = check[now] + weight;
					dfs(list, path, visit, check, n, next, cnt + 1);
				}
			}
		}

		path.remove(path.size() - 1);
	}
}
