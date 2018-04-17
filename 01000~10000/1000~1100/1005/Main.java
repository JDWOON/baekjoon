package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[] d = new int[n + 1];
			int[] min = new int[n + 1];

			for (int j = 1; j < n + 1; j++) {
				d[j] = sc.nextInt();
				min[j] = -1;
			}

			List<List<Integer>> map = new ArrayList<List<Integer>>();
			for (int j = 0; j < n + 1; j++) {
				map.add(new ArrayList<Integer>());
			}

			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map.get(y).add(x);
			}

			int w = sc.nextInt();

			System.out.println(solve(map, d, min, n, w));

		}
	}

	public static int solve(List<List<Integer>> map, int[] d, int[] min, int n, int w) {
		if (min[w] >= 0) {
			return min[w];
		} else if (map.get(w).size() == 0) {
			min[w] = d[w];
			return min[w];
		} else {
			int result = 0;
			for (int i = 0; i < map.get(w).size(); i++) {
				result = Math.max(result, solve(map, d, min, n, map.get(w).get(i)));
			}
			min[w] = result + d[w];
			return min[w];
		}
	}
}