package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			System.out.println(solve(a, b));
		}
	}

	public static String solve(String a, String b) {
		if (a.equals(b)) {
			return "No Solution.";
		}

		List<String> alist = new ArrayList<String>();
		List<String> blist = new ArrayList<String>();

		for (int i = 0; i < a.length(); i++) {
			if (isPal(a.substring(i))) {
				String temp = reverseString(a.substring(0, i));
				alist.add(temp);
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (isPal(b.substring(i))) {
				String temp = reverseString(b.substring(0, i));
				blist.add(temp);
			}
		}

		alist.add(reverseString(a));
		blist.add(reverseString(b));

		for (char c = 'a'; c <= 'z'; c++) {
			alist.add(c + reverseString(a));
			blist.add(c + reverseString(b));
		}
		while (alist.size() > 0 && blist.size() > 0 && alist.get(0).equals(blist.get(0))) {
			alist.remove(0);
			blist.remove(0);
		}

		if (alist.size() == 0 && blist.size() == 0) {
			return "No solution.";
		} else if (alist.size() == 0) {
			return blist.get(0);
		} else if (blist.size() == 0) {
			return alist.get(0);
		} else {
			if (alist.get(0).length() < blist.get(0).length()) {
				return alist.get(0);
			} else if (alist.get(0).length() > blist.get(0).length()) {
				return blist.get(0);
			} else {
				if (alist.get(0).compareTo(blist.get(0)) < 0) {
					return alist.get(0);
				} else {
					return blist.get(0);
				}
			}
		}
	}

	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

	public static boolean isPal(String s) {
		int x = 0;
		int y = s.length() - 1;
		while (x < y) {
			if (s.charAt(x) != s.charAt(y)) {
				return false;
			}
			x++;
			y--;
		}
		return true;
	}
}