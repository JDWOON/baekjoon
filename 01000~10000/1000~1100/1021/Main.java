package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();
		int pos = 0;
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		for (int i = 0; i < m; i++) {
			int next = list.indexOf(sc.nextInt());
			int d = Math.abs(next - pos);
			cnt += Math.min(d, list.size() - d);
			pos = next;
			list.remove(pos);
		}

		System.out.println(cnt);
	}
}