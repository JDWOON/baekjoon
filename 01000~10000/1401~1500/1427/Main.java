package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] cnt = new int[10];
		for (int i = 0; i < 10; i++) {
			cnt[i] = 0;
		}

		while (n > 0) {
			cnt[n % 10]++;
			n /= 10;
		}

		int result = 0;

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < cnt[i]; j++) {
				result = result * 10 + i;
			}
		}

		System.out.println(result);
	}
}