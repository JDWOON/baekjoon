package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String[] s = new String[3];

		s[0] = sc.nextLine();
		s[1] = sc.nextLine();
		s[2] = sc.nextLine();

		int[] len = { s[0].length(), s[1].length(), s[2].length() };

		int[][][] dp = new int[len[0] + 1][len[1] + 1][len[2] + 1];

		for (int i = 1; i < len[0] + 1; i++) {
			for (int j = 1; j < len[1] + 1; j++) {
				for (int k = 1; k < len[2] + 1; k++) {
					if (charEqual(s[0].charAt(i - 1), s[1].charAt(j - 1), s[2].charAt(k - 1))) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
					}
				}
			}
		}

		System.out.println(dp[len[0]][len[1]][len[2]]);
	}

	public static boolean charEqual(char a, char b, char c) {
		if (a == b && b == c) {
			return true;
		} else {
			return false;
		}
	}
}