package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		drawStar(n);
	}

	public static void drawStar(int n) {
		StringBuilder[] s = new StringBuilder[n + 1];

		for (int i = 1; i < n + 1; i++) {
			s[i] = new StringBuilder();
		}

		s[1].append("*");
		s[2].append("* *");
		s[3].append("*****");

		for (int i = 3; i < n; i *= 2) {
			for (int j = 1; j <= i; j++) {
				s[i + j].append(s[j]);
			}
			for (int j = 1; j <= i; j++) {
				while (s[i + j].length() < s[i].length() + 1) {
					s[i + j].append(' ');
				}
			}
			for (int j = 1; j <= i; j++) {
				s[i + j].append(s[j]);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				s[i].insert(0, ' ');
				s[i].append(' ');
			}
			System.out.println(s[i]);
		}

	}
}