package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			if (n != 0) {
				int[] h = new int[n + 2];
				h[0] = 0;
				h[n + 1] = 0;

				for (int i = 1; i <= n; i++) {
					h[i] = Integer.parseInt(s[i]);
				}

				Stack<Integer> st = new Stack();

				long max = 0;
				for (int i = 0; i <= n + 1; i++) {
					while (!st.empty()) {
						int prev = st.peek();
						if (h[prev] < h[i]) {
							break;
						} else {
							st.pop();
							if (!st.empty()) {
								max = Math.max(max, (long) (i - 1 - st.peek()) * (long) (h[prev]));
							}
						}
					}
					st.push(i);
				}

				System.out.println(max);
			} else {
				break;
			}
		}
	}
}