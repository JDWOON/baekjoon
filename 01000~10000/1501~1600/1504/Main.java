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
		int e = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[n + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(b + c * 1000);
			list[b].add(a + c * 1000);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] min = new int[n + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		new Main().solve(list, min, a);
		int mid = min[b];
		Arrays.fill(min, Integer.MAX_VALUE);
		new Main().solve(list, min, 1);
		int left1 = min[a];
		Arrays.fill(min, Integer.MAX_VALUE);
		new Main().solve(list, min, b);
		int right1 = min[n];
		Arrays.fill(min, Integer.MAX_VALUE);
		new Main().solve(list, min, 1);
		int left2 = min[b];
		Arrays.fill(min, Integer.MAX_VALUE);
		new Main().solve(list, min, a);
		int right2 = min[n];

		if (left1 == Integer.MAX_VALUE || left2 == Integer.MAX_VALUE || mid == Integer.MAX_VALUE
				|| right1 == Integer.MAX_VALUE || right2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(left1 + right1, left2 + right2) + mid);
		}
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
				int next = list[temp.get(now)].get(i) % 1000;
				int weight = list[temp.get(now)].get(i) / 1000;
				if (min[next] > min[temp.get(now)] + weight) {
					min[next] = min[temp.get(now)] + weight;
					temp.add(next);
				}
			}

			temp.remove(now);
		}
	}
}