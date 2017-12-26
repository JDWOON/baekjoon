package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int dp = 0;

		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			dp += val;
			if (dp > 0) {
				sum = Math.max(sum, dp);
			} else {
				dp = 0;
				max = Math.max(max, val);
			}
		}

		if (sum > 0) {
			System.out.println(sum);
		} else {
			System.out.println(max);
		}
	}
}