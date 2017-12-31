package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] val = new int[n];
			ArrayList<Integer> list = new ArrayList<Integer>();
			int pos = 0, cnt = 1;

			for (int j = 0; j < n; j++) {
				val[j] = sc.nextInt();
				list.add(j);
			}

			while (list.size() > 0) {
				int now = list.get(0);
				boolean isMax = true;
				for (int j = 1; j < list.size(); j++) {
					if (val[list.get(j)] > val[now]) {
						isMax = false;
						break;
					}
				}
				if (isMax) {
					if (list.get(0) == m) {
						System.out.println(cnt);
						break;
					} else {
						list.remove(0);
						cnt++;
					}
				} else {
					list.remove(0);
					list.add(now);
				}
			}
		}
	}
}