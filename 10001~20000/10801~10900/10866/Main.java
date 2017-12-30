package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		Deque<Integer> dq = new ArrayDeque();

		for (int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			if (s[0].equals("push_front")) {
				dq.addFirst(Integer.parseInt(s[1]));
			} else if (s[0].equals("push_back")) {
				dq.addLast(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop_front")) {
				System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
			} else if (s[0].equals("pop_back")) {
				System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
			} else if (s[0].equals("size")) {
				System.out.println(dq.size());
			} else if (s[0].equals("empty")) {
				System.out.println(dq.isEmpty() ? 1 : 0);
			} else if (s[0].equals("front")) {
				System.out.println(dq.isEmpty() ? -1 : dq.peekFirst());
			} else if (s[0].equals("back")) {
				System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
			}
		}
	}
}