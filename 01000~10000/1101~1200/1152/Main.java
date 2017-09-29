package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] s = sc.nextLine().trim().split(" ");
		int cnt = 0;
		
		for (int i = 0; i < s.length; i++) {
			if (!s[i].equals("")) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}