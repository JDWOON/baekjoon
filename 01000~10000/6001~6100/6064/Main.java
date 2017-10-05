package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			int result = -1;

			for (int j = 0; j < n; j++) {
				int temp = m * j + x;
				if (temp % n == y) {
					result = temp + 1;
					break;
				}
			}

			System.out.println(result);
		}
	}
}