package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String t = br.readLine();
		String p = br.readLine();

		int[] pi = new int[p.length() + 1];

		new Main().init(pi, p);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int now = 0;

		for (int i = 0; i < t.length(); i++) {
			if (now == -1 || t.charAt(i) == p.charAt(now)) {
				now++;
				if (now == p.length()) {
					list.add(i - p.length() + 2);
					now = pi[now];
				}
			} else {
				now = pi[now];
				i--;
			}
		}

		bw.write(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " ");
		}
		bw.flush();
	}

	public void init(int[] pi, String p) {
		int now = 0, i = 1;
		pi[0] = -1;
		while (i < p.length()) {
			if (now == -1 || p.charAt(i) == p.charAt(now)) {
				i++;
				now++;
				pi[i] = now;
			} else {
				now = pi[now];
			}
		}
	}
}