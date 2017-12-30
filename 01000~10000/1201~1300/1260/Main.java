package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		boolean[][] vertex = new boolean[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				vertex[i][j] = false;
			}
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			vertex[a][b] = true;
			vertex[b][a] = true;
		}

		boolean[] dfs = new boolean[n + 1];
		boolean[] bfs = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dfs[i] = false;
			bfs[i] = false;
		}

		new Main().dfs(vertex, dfs, v, n);
		System.out.println();
		new Main().bfs(vertex, bfs, v, n);
	}

	public void dfs(boolean[][] vertex, boolean[] dfs, int now, int n) {
		dfs[now] = true;
		System.out.print(now + " ");
		for (int i = 1; i <= n; i++) {
			if (vertex[now][i] && !dfs[i]) {
				dfs(vertex, dfs, i, n);
			}
		}
	}

	public void bfs(boolean[][] vertex, boolean[] bfs, int v, int n) {
		System.out.print(v + " ");
		Deque<Integer> dq = new ArrayDeque();
		dq.add(v);
		bfs[v] = true;

		while (dq.size() > 0) {
			int Pop = dq.pollFirst();

			for (int i = 1; i <= n; i++) {
				if (vertex[Pop][i] && !bfs[i]) {
					System.out.print(i + " ");
					dq.addLast(i);
					bfs[i] = true;
				}
			}
		}
	}
}