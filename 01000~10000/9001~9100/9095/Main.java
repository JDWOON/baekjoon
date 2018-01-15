package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int[] p = { 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504 };
		while (t > 0) {
			System.out.println(p[sc.nextInt() - 1]);
			t--;
		}
	}
}