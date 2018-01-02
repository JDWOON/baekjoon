package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < t; i++) {
			String[] s = sc.nextLine().split(" ");
			int h = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);

			for (int j = 0; j < h; j++) {
				String temp = sc.nextLine();
				String out = new String();
				for (int k = temp.length() - 1; k > -1; k--) {
					out += temp.charAt(k);
				}
				System.out.println(out);
			}
		}

	}
}