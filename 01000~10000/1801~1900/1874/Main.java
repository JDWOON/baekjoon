package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<Character> list = new ArrayList<Character>();

		int p = 1;
		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			while (p <= val) {
				s.push(p);
				list.add('+');
				p++;
			}
			if (p > val) {
				while (s.size() > 0 && s.peek() != val) {
					s.pop();
					list.add('-');
				}
				if (s.size() == 0) {
					System.out.println("NO");
					return;
				} else {
					s.pop();
					list.add('-');
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}