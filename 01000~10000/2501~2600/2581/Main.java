package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] p = new boolean[10001];
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i < 10001; i++) {
			for (int j = i * 2; j < 10001; j += i) {
				p[j] = false;
			}
		}

		int m = sc.nextInt();
		int n = sc.nextInt();
		int result = 0;
		int min = 0;
		for (int i = m; i <= n; i++) {
			if (p[i]) {
				result += i;
				if (min == 0) {
					min = i;
				}
			}
		}

		if (min > 0) {
			System.out.println(result);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}
}