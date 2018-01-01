package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] b = new boolean[10];
		Arrays.fill(b, true);
		for (int i = 0; i < m; i++) {
			b[sc.nextInt()] = false;
		}

		System.out.println(new Main().solve(b, n));
	}

	public int solve(boolean[] b, int n) {
		int val = Math.abs(n - 100);
		for (int i = 0; i < 10; i++) {
			if (b[i]) {
				val = Math.min(val, getVal(b, n, i, 1));
			}
		}
		return val;
	}

	public int getVal(boolean[] b, int n, int now, int cnt) {
		int val = Math.abs(n - now) + cnt;
		if (now < n * 10) {
			for (int i = 0; i < 10; i++) {
				if (now == 0 && i == 0) {
					continue;
				} else if (b[i]) {
					val = Math.min(val, getVal(b, n, now * 10 + i, cnt + 1));
				}
			}
		}
		return val;
	}
}