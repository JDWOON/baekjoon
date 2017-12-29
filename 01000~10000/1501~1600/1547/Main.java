package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int p = 1;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == p) {
				p = b;
			} else if (b == p) {
				p = a;
			}
		}

		System.out.println(p);
	}
}