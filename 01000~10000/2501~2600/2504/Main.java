package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		if (new Main().check(s)) {
			System.out.println(new Main().getVal(s));
		} else {
			System.out.println(0);
		}
	}

	public int getVal(String s) {
		if (s.length() == 0) {
			return 0;
		} else if (s.substring(0, 2).equals("()")) {
			return 2 + getVal(s.substring(2));
		} else if (s.substring(0, 2).equals("[]")) {
			return 3 + getVal(s.substring(2));
		} else if (s.charAt(0) == '(') {
			int cnt = 1;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					cnt++;
				} else if (s.charAt(i) == ')') {
					cnt--;
				}
				if (cnt == 0) {
					return 2 * getVal(s.substring(1, i)) + getVal(s.substring(i + 1));
				}
			}
		} else if (s.charAt(0) == '[') {
			int cnt = 1;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '[') {
					cnt++;
				} else if (s.charAt(i) == ']') {
					cnt--;
				}
				if (cnt == 0) {
					return 3 * getVal(s.substring(1, i)) + getVal(s.substring(i + 1));
				}
			}
		}
		return -1;
	}

	public boolean check(String s) {
		ArrayList<Character> list = new ArrayList<Character>();

		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		boolean find = true;

		while (find) {
			find = false;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) == '(' && list.get(i + 1) == ')') {
					list.remove(i);
					list.remove(i);
					find = true;
				} else if (list.get(i) == '[' && list.get(i + 1) == ']') {
					list.remove(i);
					list.remove(i);
					find = true;
				}
			}
		}

		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}