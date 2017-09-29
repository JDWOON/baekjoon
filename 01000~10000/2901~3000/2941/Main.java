package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (i < s.length() - 1) {
				char next = s.charAt(i + 1);
				if (now == 'c' && (next == '=' || next == '-')) {
					result++;
					i++;
				} else if (now == 'd' && next == '-') {
					result++;
					i++;
				} else if ((now == 'l' || now == 'n') && next == 'j') {
					result++;
					i++;
				} else if ((now == 's' || now == 'z') && next == '=') {
					result++;
					i++;
				} else if (i < s.length() - 2 && now == 'd' && next == 'z' && s.charAt(i + 2) == '=') {
					result++;
					i += 2;
				} else {
					result++;
				}
			} else {
				result++;
			}
		}

		System.out.println(result);
	}
}