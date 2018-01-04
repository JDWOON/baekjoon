package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int i = 1; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int[] par = new int[n + 1];
		par[1] = 0;
		new Main().getParent(list, par, 1);
		for (int i = 2; i <= n; i++) {
			System.out.println(par[i]);
		}
	}

	public void getParent(ArrayList<ArrayList<Integer>> list, int[] par, int now) {
		if (list.get(now).isEmpty()) {
			return;
		} else {
			for (int i = 0; i < list.get(now).size(); i++) {
				if (par[now] != list.get(now).get(i)) {
					par[list.get(now).get(i)] = now;
					getParent(list, par, list.get(now).get(i));
				}
			}
		}
	}
}