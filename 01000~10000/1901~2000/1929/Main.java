package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] p = new boolean[1000001];
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i < 1000; i++) {
			for (int j = i * 2; j < 1000001; j += i) {
				p[j] = false;
			}
		}

		int m = sc.nextInt();
		int n = sc.nextInt();
		for (int i = m; i <= n; i++) {
			if (p[i]) {
				System.out.println(i);
			}
		}
	}
}