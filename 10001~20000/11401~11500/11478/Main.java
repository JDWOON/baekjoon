package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int cnt = 0;

		for (int i = 1; i < s.length() + 1; i++) {
			ArrayList<String> list = new ArrayList<String>();
			for (int j = 0; j + i < s.length() + 1; j++) {
				String temp = s.substring(j, j + i);
				if (!list.contains(temp)) {
					list.add(temp);
				}
			}
			cnt += list.size();
		}

		System.out.println(cnt);
	}
}