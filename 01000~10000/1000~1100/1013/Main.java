package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String p = "^((100+1+)|(01))+$";

		for (int i = 0; i < t; i++) {
			String s = br.readLine();
			System.out.println(Pattern.matches(p, s) ? "YES" : "NO");
		}
	}
}