import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static int[] pi = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
			10946, 17711 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		int[] x = new int[t];

		for (int i = 0; i < t; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < t; i++) {
			bw.write(solve(x[i]) + "\n");
		}

		bw.flush();
	}

	public static int solve(int km) {
		String temp = intToStr(km);
		temp = temp.substring(0, temp.length() - 1);
		return strToInt(temp);
	}

	public static int strToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(s.length() - i - 1) == '1') {
				result += pi[i];
			}
		}

		return result;
	}

	public static String intToStr(int x) {
		String result = new String();
		for (int i = pi.length - 1; i > -1; i--) {
			if (x >= pi[i]) {
				result += '1';
				x %= pi[i];
			} else if (result.length() > 0) {
				result += '0';
			}
		}

		return result;
	}
}