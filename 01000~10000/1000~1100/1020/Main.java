import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	private final static int[] lines = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String now = br.readLine();

		String next = solve(now);

		long limit = (long) (Math.pow(10, now.length()));

		long result = (Long.parseLong(next) - Long.parseLong(now) + limit) % limit;

		if (result == 0) {
			result = limit;
		}

		bw.write(result + "");

		bw.flush();
	}

	public static String solve(String now) {
		int val = getLine(now);
		int len = now.length();

		for (int i = Integer.parseInt(now.substring(len - 1)) + 1; i < 10; i++) {
			String temp = now.substring(0, len - 1) + Integer.toString(i);
			if (getLine(temp) == val) {
				return temp;
			}
		}

		String next = now;

		while (next.length() > 0) {
			String temp = next.substring(0, next.length() - 1);

			for (int i = Integer.parseInt(next.substring(next.length() - 1)) + 1; i < 10; i++) {
				if (check(temp + Integer.toString(i), len, val)) {
					return getNext(temp + Integer.toString(i), len, val);
				}
			}

			next = temp;
		}

		return getNext("", len, val);
	}

	public static int getLine(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			result += lines[(int) (s.charAt(i) - '0')];
		}

		return result;
	}

	public static boolean check(String s, int len, int val) {
		int min = getLine(s) + (len - s.length()) * 2;
		int max = getLine(s) + (len - s.length()) * 7;

		if (val > max || val < min) {
			return false;
		} else {
			return true;
		}
	}

	public static String getNext(String s, int len, int val) {
		if (s.length() == len) {
			return s;
		}

		for (int i = 0; i < 10; i++) {
			String temp = s + Integer.toString(i);
			if (check(temp, len, val)) {
				return getNext(temp, len, val);
			}
		}

		return "";
	}
}