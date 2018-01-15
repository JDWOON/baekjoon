package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static char[] left = new char[1000000];
	public static char[] right = new char[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			String s = br.readLine();
			int a = 0, b = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '-') {
					if (a > 0) {
						a--;
					}
				} else if (s.charAt(i) == '<') {
					if (a > 0) {
						a--;
						right[b] = left[a];
						b++;
					}
				} else if (s.charAt(i) == '>') {
					if (b > 0) {
						b--;
						left[a] = right[b];
						a++;
					}
				} else {
					left[a] = s.charAt(i);
					a++;
				}
			}

			for (int i = 0; i < a; i++) {
				bw.write(left[i]);
			}

			for (int i = b - 1; i > -1; i--) {
				bw.write(right[i]);
			}

			bw.write("\n");
			t--;
		}
		bw.flush();
	}
}