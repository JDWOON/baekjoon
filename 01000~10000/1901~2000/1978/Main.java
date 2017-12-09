package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] p = new boolean[1001];
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i < 1001; i++) {
			for (int j = i * 2; j < 1001; j += i) {
				p[j] = false;
			}
		}

		int n = sc.nextInt();
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (p[sc.nextInt()]) {
				result++;
			}
		}
		System.out.println(result);
	}
}