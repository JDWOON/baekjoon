package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		new Main().solve(n, m);
	}

	public class Linked {
		int val;
		Linked next;
	}

	public void solve(int n, int m) throws IOException {
		Linked root = new Linked();
		root.val = 1;
		Linked idx = root;

		for (int i = 1; i < n; i++) {
			idx.next = new Linked();
			idx = idx.next;
			idx.val = i + 1;
		}

		idx.next = root;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("<");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				idx = idx.next;
			}

			if (i > 0) {
				bw.write(", ");
			}

			bw.write("" + idx.next.val);
			idx.next = idx.next.next;
		}

		bw.write(">");
		bw.flush();
	}
}