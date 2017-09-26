package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 0;
		if (n % 5 == 0) {
			k = n / 5;
		} else if (n % 5 == 1 && n >= 6) {
			k = n / 5 + 1;
		} else if (n % 5 == 2 && n >= 12) {
			k = (n - 12) / 5 + 4;
		} else if (n % 5 == 3) {
			k = n / 5 + 1;
		} else if (n % 5 == 4 && n >= 9) {
			k = (n - 9) / 5 + 3;
		} else {
			k = -1;
		}

		System.out.println(k);
	}
}