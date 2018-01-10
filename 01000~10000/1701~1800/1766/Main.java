package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int[] indegree = new int[n + 1];
		Arrays.fill(indegree, 0);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			indegree[b]++;
		}

		new Main().solve(list, indegree);
	}

	public void solve(ArrayList<Integer>[] list, int[] indegree) throws IOException {
		PriorityQueue<Integer> zero = new PriorityQueue<Integer>();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				zero.add(i);
			}
		}

		while (!zero.isEmpty()) {
			int now = zero.poll();
			bw.write(Integer.toString(now) + " ");
			editIndegree(list, indegree, zero, now);
		}

		bw.flush();
	}

	public void editIndegree(ArrayList<Integer>[] list, int[] indegree, PriorityQueue<Integer> zero, int now) {
		for (int i = 0; i < list[now].size(); i++) {
			indegree[list[now].get(i)]--;
			if (indegree[list[now].get(i)] == 0) {
				zero.add(list[now].get(i));
			}
		}
	}
}