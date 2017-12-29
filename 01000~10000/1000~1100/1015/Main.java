package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] sort = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sort[i] = a[i];
		}

		Arrays.sort(sort);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i] == sort[j]) {
					p[i] = j;
					sort[j] = -1;
					break;
				}
			}
			System.out.print(p[i] + " ");
		}

	}
}