package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine().toUpperCase();
		int[] a = new int[26];
		int max = 0, cnt = 0, result = 0;

		for (int i = 0; i < 26; i++) {
			a[i] = 0;
		}

		for (int i = 0; i < s.length(); i++) {
			int b = (int) (s.charAt(i) - 'A');
			a[b]++;
		}

		for (int i = 0; i < 26; i++) {
			max = Math.max(max, a[i]);
		}

		for (int i = 0; i < 26; i++) {
			if (a[i] == max) {
				cnt++;
				result = i;
			}
		}

		if (cnt == 1) {
			System.out.println((char) ('A' + result));
		} else {
			System.out.println("?");
		}
	}
}