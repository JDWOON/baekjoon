package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long x = Math.max(a, b), y = Math.min(a, b);
		while (x % y != 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}
		System.out.println(y);
		System.out.println(a * b / y);
	}
}