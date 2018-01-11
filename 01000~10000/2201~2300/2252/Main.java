package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}

		int[] indegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				indegree[list[i].get(j)]++;
			}
		}

		Queue<Integer> que = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				que.add(i);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (!que.isEmpty()) {
			int now = que.poll();
			bw.write(now + " ");

			for (int i = 0; i < list[now].size(); i++) {
				indegree[list[now].get(i)]--;
				if (indegree[list[now].get(i)] == 0) {
					que.add(list[now].get(i));
				}
			}
		}

		bw.flush();
	}
}