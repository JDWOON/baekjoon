package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] in = new int[n];
		int[] post = new int[n];
		int[] pre = new int[n];

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(s[i]);
		}

		s = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(s[i]);
		}

		new Main().getPre(in, post, pre, 0, 0, 0, n);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(pre[i]);
			sb.append(i < n - 1 ? " " : "\n");
		}

		System.out.println(sb);
	}

	public void getPre(int[] in, int[] post, int[] pre, int a, int b, int c, int len) {
		if (len > 0) {
			int root = post[b + len - 1];
			pre[c] = root;
			int left = 0, right = 0;
			for (int i = a; i < a + len; i++) {
				if (in[i] == root) {
					left = i - a;
					right = a + len - i - 1;
					break;
				}
			}

			getPre(in, post, pre, a, b, c + 1, left);
			getPre(in, post, pre, a + left + 1, b + left, c + left + 1, right);
		}
	}
}