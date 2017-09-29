package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int i;
		for (i = 1; 3 * i * (i - 1) + 1 < n; i++) {
			continue;
		}

		System.out.println(i);
	}
}