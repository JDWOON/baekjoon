package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		String a = sc.nextLine();
		String b = sc.nextLine();
		int[] val = new int[a.length() * 2];

		for (int i = 0; i < a.length(); i++) {
			val[i * 2] = p[(int) (a.charAt(i) - 'A')];
			val[i * 2 + 1] = p[(int) (b.charAt(i) - 'A')];
		}

		for (int i = val.length; i > 2; i--) {
			for (int j = 0; j < i - 1; j++) {
				val[j] = (val[j] + val[j + 1]) % 10;
			}
		}

		System.out.println(val[0] + "" + val[1]);
	}
}