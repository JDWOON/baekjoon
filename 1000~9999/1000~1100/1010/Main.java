package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			long result = 1;
			int x = n + 1, y = 2;

			while (x < m + 1 || y < m - n + 1) {
				if (y < m - n + 1 && result % y == 0) {
					result /= y;
					y++;
				} else if (x < m + 1) {
					result *= x;
					x++;
				}
			}
			
			System.out.println(result);
		}

	}
}