package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			t--;

			int n = Integer.parseInt(br.readLine());
			int[] last = new int[n + 1];
			ArrayList<Integer>[] list = new ArrayList[n + 1];

			for (int i = 0; i < n + 1; i++) {
				list[i] = new ArrayList<Integer>();
			}

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= n; i++) {
				last[i] = Integer.parseInt(st.nextToken());
				for (int j = 1; j < i; j++) {
					list[last[j]].add(last[i]);
				}
			}

			int m = Integer.parseInt(br.readLine());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (list[a].indexOf(b) < 0) {
					list[a].add(b);
					list[b].remove(list[b].indexOf(a));
				} else {
					list[b].add(a);
					list[a].remove(list[a].indexOf(b));
				}
			}

			int[] indegree = new int[n + 1];
			Arrays.fill(indegree, 0);

			for (int i = 1; i < list.length; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					indegree[list[i].get(j)]++;
				}
			}

			Queue<Integer> que = new ArrayDeque<Integer>();

			for (int i = 1; i < indegree.length; i++) {
				if (indegree[i] == 0) {
					que.add(i);
				}
			}

			ArrayList<Integer> result = new ArrayList<Integer>();
			while (!que.isEmpty() && que.size() < 2) {
				int now = que.poll();
				result.add(now);
				for (int i = 0; i < list[now].size(); i++) {
					indegree[list[now].get(i)]--;
					if (indegree[list[now].get(i)] == 0) {
						que.add(list[now].get(i));
					}
				}
			}
			if (que.isEmpty() && result.size() < n) {
				System.out.println("IMPOSSIBLE");
			} else if (que.size() > 1) {
				System.out.println("?");
			} else {
				for (int i = 0; i < result.size(); i++) {
					System.out.print(result.get(i) + " ");
				}
				System.out.println();
			}
		}
	}
}