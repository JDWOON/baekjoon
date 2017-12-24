package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		for (int i = 1; i < n; i++) {
			int b = sc.nextInt();
			int x = Math.max(a, b), y = Math.min(a, b);
			while (x % y != 0) {
				int temp = y;
				y = x % y;
				x = temp;
			}
			System.out.println(a / y + "/" + b / y);
		}
	}
}