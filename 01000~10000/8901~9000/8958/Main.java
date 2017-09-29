package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int result = 0, temp = 1;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'O') {
					result += temp;
					temp++;
				} else {
					temp = 1;
				}
			}

			System.out.println(result);
		}
	}
}