package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for (int i = 0; i < s.length(); i += 10) {
			System.out.println(s.substring(i, Math.min(s.length(), i + 10)));
		}
	}
}