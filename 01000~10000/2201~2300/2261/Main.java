package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt() + 10000;
			int y = sc.nextInt() + 10000;
			p[i] = x * 20001 + y;
		}

		Arrays.sort(p);

		int min = (p[0] / 20001 - p[1] / 20001) * (p[0] / 20001 - p[1] / 20001);
		min += (p[0] % 20001 - p[1] % 20001) * (p[0] % 20001 - p[1] % 20001);
		for (int i = 0; i < p.length - 1; i++) {
			int x1 = p[i] / 20001, y1 = p[i] % 20001;
			for (int j = i + 1; j < p.length; j++) {
				int x2 = p[j] / 20001, y2 = p[j] % 20001;

				int len = (x1 - x2) * (x1 - x2);
				if (len >= min) {
					break;
				} else {
					len += (y1 - y2) * (y1 - y2);
					if (len < min) {
						min = len;
					}
				}
			}
		}

		System.out.println(min);
	}
}