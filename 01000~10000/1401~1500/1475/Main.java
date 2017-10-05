package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] cnt = new int[10];

		String s = sc.next();

		for (int i = 0; i < s.length(); i++) {
			cnt[(int) (s.charAt(i) - '0')]++;
		}

		cnt[6] = (cnt[6] + cnt[9]) / 2 + (cnt[6] + cnt[9]) % 2;
		cnt[9] = cnt[6];

		int result = 0;

		for (int i = 0; i < 10; i++) {
			result = Math.max(result, cnt[i]);
		}

		System.out.println(result);
	}
}