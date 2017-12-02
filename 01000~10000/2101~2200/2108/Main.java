package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		int[] cnt = new int[8001];
		Arrays.fill(cnt, 0);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
			cnt[p[i] + 4000]++;
			sum += p[i];
		}

		Arrays.sort(p);
		int maxCnt = -1;
		int dup = 0;
		int result = 0;

		for (int i = 0; i < 8001; i++) {
			if (maxCnt < cnt[i]) {
				maxCnt = cnt[i];
				result = i - 4000;
				dup = 0;
			} else if (maxCnt == cnt[i] && dup == 0) {
				result = i - 4000;
				dup++;
			}
		}

		System.out.println(Math.round((float) sum / (float) n));
		System.out.println(p[(n - 1) / 2]);
		System.out.println(result);
		System.out.println(p[n - 1] - p[0]);
	}
}