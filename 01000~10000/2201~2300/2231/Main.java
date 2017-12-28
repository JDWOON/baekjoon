package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			int val = i;

			for (int j = i; j > 0; j /= 10) {
				val += j % 10;
			}

			if (val == n) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
	}
}