package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] p = new int[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				p[i][j] = temp.charAt(j) == '1' ? 1 : 0;
			}
		}

		String result = new Main().quad(p, 0, 0, n);
		if (result.length() > 1) {
			System.out.println("(" + result + ")");
		} else {
			System.out.println(result);
		}
	}

	public String quad(int[][] p, int x, int y, int len) {
		if (len == 1) {
			return Integer.toString(p[x][y]);
		} else {
			String a = quad(p, x, y, len / 2);
			String b = quad(p, x, y + len / 2, len / 2);
			String c = quad(p, x + len / 2, y, len / 2);
			String d = quad(p, x + len / 2, y + len / 2, len / 2);
			if (a.length() == 1 && a.equals(b) && a.equals(c) && a.equals(d)) {
				return a;
			} else {
				String s = new String();
				s += a.length() > 1 ? "(" + a + ")" : a;
				s += b.length() > 1 ? "(" + b + ")" : b;
				s += c.length() > 1 ? "(" + c + ")" : c;
				s += d.length() > 1 ? "(" + d + ")" : d;
				return s;
			}
		}
	}
}