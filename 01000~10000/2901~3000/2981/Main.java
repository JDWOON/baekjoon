package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			min = Math.min(min, num[i + 1] - num[i]);
		}

		ArrayList<Integer> cd = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 1; i <= Math.sqrt(min); i++) {
			if (min % i == 0) {
				cd.add(cnt, min / i);
				if (min != i * i) {
					cd.add(cnt, i);
				}
				cnt++;
			}
		}

		for (int i = 1; i < cd.size(); i++) {
			boolean answer = true;
			int mod = num[0] % cd.get(i);
			for (int j = 1; j < n; j++) {
				if (num[j] % cd.get(i) != mod) {
					answer = false;
					break;
				}
			}
			if (answer) {
				System.out.print(cd.get(i) + " ");
			}
		}
	}
}