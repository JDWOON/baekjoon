package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean asc = true, desc = true;
		for (int i = 0; i < 8; i++) {
			int temp = sc.nextInt();
			if (asc && temp != i + 1) {
				asc = false;
			}
			if (desc && temp != 8 - i) {
				desc = false;
			}
		}

		if (asc) {
			System.out.println("ascending");
		} else if (desc) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}