package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			int cnt = sc.nextInt();
			cnt += sc.nextInt();
			cnt += sc.nextInt();
			cnt += sc.nextInt();
			if (cnt < 4) {
				System.out.println((char)('D' - cnt));
			} else {
				System.out.println("E");
			}
		}
	}
}