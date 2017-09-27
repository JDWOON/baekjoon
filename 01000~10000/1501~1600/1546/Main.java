package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double max = 0;
		double result = 0;

		for (int i = 0; i < n; i++) {
			double temp = sc.nextDouble();
			max = Math.max(max, temp);
			result += temp;
		}
		result = (double) Math.round(result / max / n * 10000) / 100;

		System.out.println(String.format("%.2f", result));
	}
}