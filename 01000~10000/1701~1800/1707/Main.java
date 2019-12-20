import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] list = new ArrayList[v];
			for (int j = 0; j < v; j++) {
				list[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				list[a].add(b);
				list[b].add(a);
			}

			String result = solve(list, v) ? "YES" : "NO";

			bw.write(result + "\n");
		}

		bw.flush();
	}

	public static boolean solve(ArrayList<Integer>[] list, int v) {
		boolean[] visit = new boolean[v];
		boolean[] grp = new boolean[v];
		Arrays.fill(visit, false);

		for (int i = 0; i < v; i++) {
			if (!visit[i]) {
				dfs(list, visit, grp, i, true);
			}
		}

		for (int i = 0; i < v; i++) {
			for (int j : list[i]) {
				if (grp[i] == grp[j]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void dfs(ArrayList<Integer>[] list, boolean[] visit, boolean[] grp, int now, boolean nowGrp) {
		if (!visit[now]) {
			visit[now] = true;
			grp[now] = nowGrp;

			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);

				if (!visit[next]) {
					dfs(list, visit, grp, next, !nowGrp);
				}
			}
		}
	}
}
