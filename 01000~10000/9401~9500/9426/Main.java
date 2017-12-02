package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		List<Integer> list = new ArrayList<Integer>();
		long result = 0;

		for (int i = 0; i < n; i++) {
			if (i >= k) {
				list.remove(list.indexOf(p[i - k]));
			}

			int j = 0;
			for (j = 0; j < list.size(); j++) {
				if (p[i] < list.get(j)) {
					list.add(j, p[i]);
					break;
				}
			}
			if (j == list.size()) {
				list.add(p[i]);
			}

			if (list.size() == k) {
				result += (long) (list.get((k - 1) / 2));
			}
		}

		System.out.println(result);
	}
}