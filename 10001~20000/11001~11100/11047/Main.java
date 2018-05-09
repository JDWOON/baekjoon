package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int sum = 0;

		for (int i = n - 1; i > -1; i--) {
			sum += k / a[i];
			k %= a[i];
		}

		System.out.println(sum);
	}
}