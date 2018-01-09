package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}

		int[] cnt = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			cnt[i] = new Main().solve(list, i);
			max = Math.max(max, cnt[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (max == cnt[i]) {
				System.out.print(i + " ");
			}
		}
	}

	public int solve(ArrayList<ArrayList<Integer>> list, int root) {
		boolean[] visit = new boolean[list.size()];
		Arrays.fill(visit, false);
		return dfs(list, visit, root);
	}

	public int dfs(ArrayList<ArrayList<Integer>> list, boolean[] visit, int now) {
		if (visit[now]) {
			return 0;
		} else {
			visit[now] = true;
			int val = 1;
			for (int i = 0; i < list.get(now).size(); i++) {
				val += dfs(list, visit, list.get(now).get(i));
			}
			return val;
		}
	}
}