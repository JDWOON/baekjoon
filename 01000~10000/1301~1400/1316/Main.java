package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int result = 0;

		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			boolean[] a = new boolean[26];
			boolean group = true;

			for (int j = 0; j < 26; j++) {
				a[j] = true;
			}

			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (a[(int) (c - 'a')]) {
					a[(int) (c - 'a')] = false;
					while (j < s.length() - 1 && c == s.charAt(j + 1)) {
						j++;
					}
				} else {
					group = false;
				}
			}

			if (group) {
				result++;
			}
		}

		System.out.println(result);
	}
}