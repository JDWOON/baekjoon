package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		int[] a = new int[26];

		for (int i = 0; i < 26; i++) {
			a[i] = -1;
		}

		for (int i = 0; i < s.length(); i++) {
			int c = (int) (s.charAt(i) - 'a');
			if (a[c] == -1) {
				a[c] = i;
			}
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(a[i] + " ");
		}
	}
}