package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();

		while (l * (l - 1) / 2 <= n && l < 101) {
			int k = (2 * n / l - l + 1) / 2;
			if (l * (2 * k + l - 1) / 2 == n) {
				for (int i = k; i < k + l; i++) {
					System.out.print(i + " ");
				}
				return;
			}
			l++;
		}
		System.out.println(-1);
	}
}