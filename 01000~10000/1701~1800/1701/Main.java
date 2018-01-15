package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		System.out.println(new Main().solve(s));
	}

	public int solve(String s) {
		int max = 0;

		for (int i = 0; i < s.length() - max; i++) {
			max = Math.max(max, maxPI(s, i));
		}

		return max;
	}

	public int maxPI(String p, int start) {
		int[] pi = new int[p.length() - start + 1];
		int now = 0, i = start + 1, max = 0;
		pi[0] = -1;
		while (i < p.length()) {
			if (now == -1 || p.charAt(i) == p.charAt(now + start)) {
				i++;
				now++;
				pi[i - start] = now;
				max = Math.max(max, now);
			} else {
				now = pi[now];
			}
		}

		return max;
	}
}