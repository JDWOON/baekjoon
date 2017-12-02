package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		int[] result = new int[n];

		for (int len = 1; len < n; len *= 2) {
			for (int left = 0; left < n; left += len * 2) {
				int right = left + len;
				int end = Math.min(n, right + len);
				int a = left;
				int b = right;

				for (int pos = left; pos < end; pos++) {
					if (a < right && b < end) {
						if (p[a] < p[b]) {
							result[pos] = p[a];
							a++;
						} else {
							result[pos] = p[b];
							b++;
						}
					} else if (a < right) {
						result[pos] = p[a];
						a++;
					} else if (b < end) {
						result[pos] = p[b];
						b++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				p[i] = result[i];
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(p[i]);
		}
	}
}