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

		int n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		int[] part = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			part[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int need = Integer.parseInt(st.nextToken());
				if (need == -1) {
					break;
				} else {
					list.get(i).add(need);
				}
			}
		}

		int[] total = new int[n + 1];
		Arrays.fill(total, -1);

		for (int i = 1; i <= n; i++) {
			System.out.println(new Main().getTime(list, part, total, i));
		}
	}

	public int getTime(ArrayList<ArrayList<Integer>> list, int[] part, int[] total, int now) {
		if (total[now] != -1) {
			return total[now];
		} else if (list.get(now).size() == 0) {
			total[now] = part[now];
			return total[now];
		} else {
			for (int i = 0; i < list.get(now).size(); i++) {
				total[now] = Math.max(total[now], getTime(list, part, total, list.get(now).get(i)));
			}
			total[now] += part[now];
			return total[now];
		}
	}
}