package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] left = new int[26];
		int[] right = new int[26];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int p = (int) (s.charAt(0) - 'A');
			if (s.charAt(2) != '.') {
				left[p] = (int) (s.charAt(2) - 'A');
			} else {
				left[p] = -1;
			}
			if (s.charAt(4) != '.') {
				right[p] = (int) (s.charAt(4) - 'A');
			} else {
				right[p] = -1;
			}
		}

		System.out.println(new Main().preorder(left, right, 0));
		System.out.println(new Main().inorder(left, right, 0));
		System.out.println(new Main().postorder(left, right, 0));
	}

	public String preorder(int[] left, int[] right, int now) {
		if (now < 0) {
			return "";
		} else {
			return (char) ('A' + now) + preorder(left, right, left[now]) + preorder(left, right, right[now]);
		}
	}

	public String inorder(int[] left, int[] right, int now) {
		if (now < 0) {
			return "";
		} else {
			return inorder(left, right, left[now]) + (char) ('A' + now) + inorder(left, right, right[now]);
		}
	}

	public String postorder(int[] left, int[] right, int now) {
		if (now < 0) {
			return "";
		} else {
			return postorder(left, right, left[now]) + postorder(left, right, right[now]) + (char) ('A' + now);
		}
	}
}