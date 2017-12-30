package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();

			Deque<Integer> deq = new ArrayDeque();
			int temp = 0;
			for (int j = 1; j < s.length() - 1; j++) {
				if (s.charAt(j) <= '9' && s.charAt(j) >= '0') {
					temp *= 10;
					temp += (int) (s.charAt(j) - '0');
					if (j == s.length() - 2) {
						deq.addLast(temp);
					}
				} else {
					deq.addLast(temp);
					temp = 0;
				}
			}

			boolean reverse = false, err = false;

			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == 'R') {
					reverse = !reverse;
				} else {
					if (deq.size() == 0) {
						err = true;
						break;
					} else if (reverse) {
						deq.pollLast();
					} else {
						deq.pollFirst();
					}
				}
			}
			if (err) {
				sb.append("error\n");
			} else {
				sb.append("[");
				if (reverse) {
					while (deq.size() > 0) {
						sb.append(deq.pollLast());
						if (deq.size() > 0) {
							sb.append(',');
						}
					}
				} else {
					while (deq.size() > 0) {
						sb.append(deq.pollFirst());
						if (deq.size() > 0) {
							sb.append(',');
						}
					}
				}
				sb.append("]\n");
			}
		}

		System.out.println(sb);
	}
}