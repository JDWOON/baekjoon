package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < t; i++) {
			String s = sc.nextLine();
			int cnt = 0;
			boolean ch = true;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					cnt++;
				} else if (cnt == 0) {
					ch = false;
					break;
				} else {
					cnt--;
				}
			}

			if (cnt == 0 && ch) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}