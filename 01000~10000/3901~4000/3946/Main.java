package baekjoon;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		for (int p = sc.nextInt(); p > 0; p--) {
			int n = sc.nextInt();
			double l = sc.nextDouble();
			double r = sc.nextDouble();

			double[][] dp = new double[n + 1][n + 1];

			double result = solve(dp, n, 0, l, r);

			DecimalFormat format = new DecimalFormat("0.0000");

			System.out.println(String.format(format.format(result)));
		}
	}

	public static double solve(double[][] dp, int now, int start, double l, double r) {
		if (now == 0 || r == 0) {
			return start;
		} else {
			if (dp[now][start] == 0) {
				double right = solve(dp, now - 1, Math.max(0, start - 1), l, r) + 1;
				double stop = solve(dp, now - 1, start, l, r);
				double left = solve(dp, now - 1, start + 1, l, r) - 1;

				dp[now][start] = r * right + l * left + (1 - r - l) * stop;
			}
			return dp[now][start];
		}
	}
}