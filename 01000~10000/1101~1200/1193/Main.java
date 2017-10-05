package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int n = 1;

		for (n = 1; n * (n + 1) / 2 < x; n++) {
			continue;
		}

		int a = x - n * (n - 1) / 2;
		int b = n + 1 - a;

		if (n % 2 == 1) {
			System.out.println(b + "/" + a);
		} else {
			System.out.println(a + "/" + b);
		}
	}
}