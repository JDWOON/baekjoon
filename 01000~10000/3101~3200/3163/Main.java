package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int k = sc.nextInt();
			int[] line = new int[l];
			Arrays.fill(line, 0);

			int lSize = 0, rSize = 0;

			for (int j = 0; j < n; j++) {
				int pos = sc.nextInt();
				line[pos] = sc.nextInt();
				if (line[pos] < 0) {
					lSize++;
				} else {
					rSize++;
				}
			}

			int[] ltime = new int[lSize];
			int[] rtime = new int[rSize];
			int[] ant = new int[n];
			int left = 0, right = 0, cnt = 0;

			for (int j = 1; j <= l - 1; j++) {
				if (line[j] != 0) {
					if (line[j] < 0) {
						ltime[left] = j;
						left++;
					} else if (line[j] > 0) {
						rtime[right] = l - j;
						right++;
					}
					ant[cnt] = line[j];
					cnt++;
				}
			}

			left = 0;
			right = 0;
			int result = 0;

			for (int j = 1; j <= k; j++) {
				if (left >= lSize) {
					result = ant[n - 1 - right];
					right++;
				} else if (right >= rSize) {
					result = ant[left];
					left++;
				} else if (ltime[left] < rtime[rSize - 1 - right]) {
					result = ant[left];
					left++;
				} else if (ltime[left] > rtime[rSize - 1 - right]) {
					result = ant[n - 1 - right];
					right++;
				} else {
					if (ant[left] < ant[n - 1 - right]) {
						result = ant[left];
						left++;
					} else {
						result = ant[n - 1 - right];
						right++;
					}
				}
			}

			System.out.println(result);
		}
	}
}