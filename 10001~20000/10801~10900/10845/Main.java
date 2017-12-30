package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Deque<Integer> dq = new ArrayDeque();

		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			if (s[0].equals("push")) {
				dq.addLast(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop")) {
				System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
			} else if (s[0].equals("size")) {
				System.out.println(dq.size());
			} else if (s[0].equals("empty")) {
				System.out.println(dq.isEmpty() ? 1 : 0);
			} else if (s[0].equals("front")) {
				System.out.println(dq.isEmpty() ? -1 : dq.getFirst());
			} else if (s[0].equals("back")) {
				System.out.println(dq.isEmpty() ? -1 : dq.getLast());
			}
		}
	}
}