package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt() - 1;
		int b = sc.nextInt() - 1;
		int r = 0;
		while (a != b) {
			a /= 2;
			b /= 2;
			r++;
		}
		System.out.println(r);
	}
}