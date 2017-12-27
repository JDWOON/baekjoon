package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int min = -1;
		int sum = 0;
		for (int i = (int) Math.sqrt(m); i <= (int) Math.sqrt(n); i++) {
			if (i * i >= m) {
				sum += i * i;
				if (min == -1) {
					min = i * i;
				}
			}
		}

		if (min != -1) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}
}