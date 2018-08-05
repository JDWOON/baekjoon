package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int[] node = new int[10000];
		int[] left = new int[10000];
		int[] right = new int[10000];

		Arrays.fill(node, -1);
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);

		int len = 0;

		while (sc.hasNextLine()) {
			String temp = sc.nextLine();

			if (temp.length() <= 0) {
				break;
			}

			node[len] = Integer.parseInt(temp);
			int idx = 0;
			while (node[idx] != node[len]) {
				if (node[idx] < node[len]) {
					if (right[idx] == -1) {
						right[idx] = len;
					}

					idx = right[idx];
				} else {
					if (left[idx] == -1) {
						left[idx] = len;
					}

					idx = left[idx];
				}
			}
			len++;
		}

		new Main().postorder(node, left, right, 0);
	}

	public void postorder(int[] node, int[] left, int[] right, int now) {
		if (left[now] != -1) {
			postorder(node, left, right, left[now]);
		}
		if (right[now] != -1) {
			postorder(node, left, right, right[now]);
		}
		System.out.println(node[now]);
	}
}