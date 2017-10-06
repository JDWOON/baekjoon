package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p = new int[46];
		p[0] = 0;
		p[1] = 1;

		for (int i = 2; i < 46; i++) {
			p[i] = p[i - 1] + p[i - 2];
		}

		int n = sc.nextInt();

		System.out.println(p[n]);
	}
}