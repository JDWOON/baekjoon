package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(new Main().solve(n, k));
	}

	public int solve(int n, int k) {
		if (n < 1 || k < 1 || n == k) {
			return 1;
		} else {
			return solve(n - 1, k - 1) + solve(n - 1, k);
		}
	}
}