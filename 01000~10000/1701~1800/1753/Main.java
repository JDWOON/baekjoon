package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] list = new ArrayList[v + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(w * 100000 + b);
		}

		int[] min = new int[v + 1];
		Arrays.fill(min, Integer.MAX_VALUE);

		new Main().solve(list, min, k);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < min.length; i++) {
			if (min[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(min[i] + "\n");
			}
		}
		bw.flush();
	}

	public void solve(ArrayList<Integer>[] list, int[] min, int k) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		min[k] = 0;
		temp.add(k);

		while (!temp.isEmpty()) {
			int now = 0;
			for (int i = 1; i < temp.size(); i++) {
				if (min[temp.get(now)] > min[temp.get(i)]) {
					now = i;
				}
			}

			for (int i = 0; i < list[temp.get(now)].size(); i++) {
				int next = list[temp.get(now)].get(i) % 100000;
				int weight = list[temp.get(now)].get(i) / 100000;
				if (min[next] > min[temp.get(now)] + weight) {
					min[next] = min[temp.get(now)] + weight;
					temp.add(next);
				}
			}

			temp.remove(now);
		}
	}
}