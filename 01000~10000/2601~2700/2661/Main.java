package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static boolean isFind = false;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		dfs("1", n);
	}

	public static void dfs(String s, int n) {
		if (isFind) {
			return;
		} else if (s.length() == n) {
			isFind = true;
			System.out.println(s);
		} else {
			for (int i = 1; i <= 3; i++) {
				if (isGood(s + i)) {
					dfs(s + i, n);
				}
			}
		}
	}

	public static boolean isGood(String s) {
		int len = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			if (s.substring(len - i, len).equals(s.substring(len - 2 * i, len - i))) {
				return false;
			}
		}
		return true;
	}
}