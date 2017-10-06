package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		Arrays.sort(p);

		for (int i = 0; i < n; i++) {
			System.out.println(p[i]);
		}
	}
}