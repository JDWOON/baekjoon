package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();

		int len = (int) Math.log10(getVal(r1, c1));
		len = Math.max(len, (int) Math.log10(getVal(r1, c2)));
		len = Math.max(len, (int) Math.log10(getVal(r2, c1)));
		len = Math.max(len, (int) Math.log10(getVal(r2, c2)));

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				System.out.print(String.format("%" + (len + 1) + "d", getVal(i, j)) + " ");
			}
			System.out.println("");
		}

	}

	public static int getVal(int r, int c) {
		int line = Math.max(Math.abs(r), Math.abs(c));
		int val = (2 * line - 1) * (2 * line - 1);
		if (r < c) {
			val += 2 * line - r - c;
		} else if (r > c) {
			val += 6 * line + r + c;
		} else if (r == c && c < 0) {
			val += 4 * line;
		} else {
			val += 8 * line;
		}
		return val;
	}
}