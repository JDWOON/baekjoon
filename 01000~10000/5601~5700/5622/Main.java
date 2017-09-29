package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'C') {
				result += 3;
			} else if (c <= 'F') {
				result += 4;
			} else if (c <= 'I') {
				result += 5;
			} else if (c <= 'L') {
				result += 6;
			} else if (c <= 'O') {
				result += 7;
			} else if (c <= 'S') {
				result += 8;
			} else if (c <= 'V') {
				result += 9;
			} else if (c <= 'Z') {
				result += 10;
			}
		}

		System.out.println(result);
	}
}