package baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (list.indexOf(s) < 0) {
				list.add(s);
			}
		}

		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else if (s1.length() < s2.length()) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}