package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] list = new long[1023];
		String dic = "9876543210";

		for (int i = 0; i < 1023; i++) {
			String s = new String();
			int temp = i + 1;
			for (int j = 0; j < 10; j++) {
				if (temp % 2 == 1) {
					s += dic.charAt(j);
				}
				temp /= 2;
			}
			list[i] = Long.parseLong(s);
		}

		Arrays.sort(list);

		if (n >= 1023) {
			System.out.println(-1);
		} else {
			System.out.println(list[n]);
		}
	}
}