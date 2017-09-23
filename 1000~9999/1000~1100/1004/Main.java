package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int n = sc.nextInt();
			int result = 0;

			for (int j = 0; j < n; j++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();

				int d1 = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
				int d2 = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);

				if ((d1 < r * r && d2 > r * r) || (d1 > r * r && d2 < r * r)) {
					result++;
				}
			}

			System.out.print(result);
			if (i < t - 1) {
				System.out.println("");
			}
		}
	}
}