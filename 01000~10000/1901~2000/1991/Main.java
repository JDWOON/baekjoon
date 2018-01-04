package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] left = new int[26];
		int[] right = new int[26];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int p = (int) (s.charAt(0) - 'A');
			if (s.charAt(2) != '.') {
				left[p] = (int) (s.charAt(2) - 'A');
			} else {
				left[p] = -1;
			}
			if (s.charAt(4) != '.') {
				right[p] = (int) (s.charAt(4) - 'A');
			} else {
				right[p] = -1;
			}
		}

		System.out.println(new Main().order(left, right, 0, "pre"));
		System.out.println(new Main().order(left, right, 0, "in"));
		System.out.println(new Main().order(left, right, 0, "post"));
	}

	public String order(int[] left, int[] right, int now, String opt) {
		if (now < 0) {
			return "";
		} else if (opt.equals("pre")) {
			return (char) ('A' + now) + order(left, right, left[now], opt) + order(left, right, right[now], opt);
		} else if (opt.equals("in")) {
			return order(left, right, left[now], opt) + (char) ('A' + now) + order(left, right, right[now], opt);
		} else if (opt.equals("post")) {
			return order(left, right, left[now], opt) + order(left, right, right[now], opt) + (char) ('A' + now);
		} else {
			return "";
		}
	}
}