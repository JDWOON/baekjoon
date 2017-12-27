package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		String lcs = new Main().solve(s1, s2);
		System.out.println(lcs.length());
		System.out.println(lcs);
	}

	public String solve(String s1, String s2) {
		String[][] lcs = new String[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < lcs.length; i++) {
			lcs[i][0] = "";
		}

		for (int i = 0; i < lcs[0].length; i++) {
			lcs[0][i] = "";
		}

		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					if (lcs[i][j - 1].length() > lcs[i - 1][j].length()) {
						lcs[i][j] = lcs[i][j - 1];
					} else {
						lcs[i][j] = lcs[i - 1][j];
					}
				}
			}
		}

		return lcs[s1.length()][s2.length()];
	}
}