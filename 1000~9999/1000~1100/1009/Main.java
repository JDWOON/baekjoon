package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt() % 10;
			int b = sc.nextInt() % 4 + 4;
			int result = 1;
			for (int j = 0; j < b; j++) {
				result *= a;
			}
			System.out.println((result + 9) % 10 + 1);
		}
	}
}