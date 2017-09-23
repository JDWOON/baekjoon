package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			int temp = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

			if (temp == 0 && r1 == r2) {
				System.out.println(-1);
			} else if (temp == 0) {
				System.out.println(0);
			} else if (temp == (r1 + r2) * (r1 + r2) || temp == (r1 - r2) * (r1 - r2)
					|| temp == (r2 - r1) * (r2 - r1)) {
				System.out.println(1);
			} else if (temp > (r1 + r2) * (r1 + r2) || temp < (r1 - r2) * (r1 - r2) || temp < (r2 - r1) * (r2 - r1)) {
				System.out.println(0);
			} else {
				System.out.println(2);
			}

		}

	}
}