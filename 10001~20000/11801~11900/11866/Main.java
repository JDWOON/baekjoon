package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Deque<Integer> dq = new ArrayDeque();
		for (int i = 0; i < n; i++) {
			dq.addLast(i + 1);
		}

		String s = "<";
		while (dq.size() > 0) {
			if (dq.size() > 1) {
				for (int i = 1; i < m; i++) {
					int now = dq.pollFirst();
					dq.addLast(now);
				}
				s += dq.pollFirst() + ", ";
			} else {
				s += dq.pollFirst() + ">";
			}
		}
		System.out.println(s);
	}
}