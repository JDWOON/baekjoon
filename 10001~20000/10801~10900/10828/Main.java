package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			String[] c = sc.nextLine().split(" ");
			if (c.length == 2) {
				st.push(Integer.parseInt(c[1]));
			} else if (c[0].equals("pop")) {
				if (st.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(st.pop());
				}
			} else if (c[0].equals("top")) {
				if (st.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(st.peek());
				}
			} else if (c[0].equals("size")) {
				System.out.println(st.size());
			} else if (c[0].equals("empty")) {
				if (st.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}
}