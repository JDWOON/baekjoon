package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long mod = 1000000007;
		int n = sc.nextInt();
		int[] p = new int[n + 1];
		p[0] = n;
		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt() + i;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(n);
		long result = 1;
		for (int i = 1; i <= n; i++) {
			while (list.get(0) < i) {
				list.remove(0);
			}

			result = (result * list.size()) % mod;

			list.add(new Main().getIndex(list, p[i]), p[i]);
		}

		System.out.println(result);

	}

	public int getIndex(ArrayList<Integer> list, int x) {
		int p = 0, left = 0, right = list.size();

		while (right - left > 4) {
			p = (right + left) / 2;
			if (list.get(p) < x) {
				left = p;
			} else {
				right = p;
			}

		}

		for (p = left; p < list.size() && p <= right; p++) {
			if (list.get(p) >= x) {
				break;
			}
		}
		return p;
	}
}