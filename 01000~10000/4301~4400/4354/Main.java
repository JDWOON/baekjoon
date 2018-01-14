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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		while (s.charAt(0) != '.') {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= Math.sqrt(s.length()); i++) {
				if (s.length() % i == 0) {
					list.add(i);
					list.add(s.length() / i);
				}
			}
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (s.charAt(i) != s.charAt(i % list.get(j))) {
						list.remove(j);
						j--;
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				min = Math.min(min, list.get(i));
			}
			bw.write((s.length() / min) + "\n");

			s = br.readLine();
		}

		bw.flush();
	}
}