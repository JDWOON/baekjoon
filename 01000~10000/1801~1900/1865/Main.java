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

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			t--;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] list = new ArrayList[n + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add((c + 10000) * 10000 + b);
				list[b].add((c + 10000) * 10000 + a);
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add((10000 - c) * 10000 + b);
			}

			int[] min = new int[n + 1];
			Arrays.fill(min, Integer.MAX_VALUE);
			min[1] = 0;

			new Main().solve(list, min, 1, 0);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			if (min[0] < 0) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
			bw.flush();

		}
	}

	public void solve(ArrayList<Integer>[] list, int[] min, int now, int time) {
		for (int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i) % 10000;
			int weight = list[now].get(i) / 10000 - 10000;
			if (min[next] < 0 && min[next] > time + weight) {
				min[0] = -1;
				return;
			} else if (min[next] > time + weight) {
				min[next] = time + weight;
				solve(list, min, next, time + weight);
			}
		}
	}
}