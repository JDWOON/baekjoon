package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] p = new boolean[250000];
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i < 500; i++) {
			for (int j = i * 2; j < 250000; j += i) {
				p[j] = false;
			}
		}

		int n = sc.nextInt();
		while (n > 0) {
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (p[i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
			n = sc.nextInt();
		}
	}
}