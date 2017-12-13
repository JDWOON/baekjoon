package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = 0;

		for (int i = 5; i <= n; i *= 5) {
			result += n / i;
		}

		System.out.println(result);
	}
}