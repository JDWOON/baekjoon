package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = 0;

			while (a > 0) {
				result = b % a == 0 ? b / a : b / a + 1;
				a = a * result - b;
				b = b * result;
			}

			System.out.println(result);
		}
	}
}