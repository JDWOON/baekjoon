import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		String[] s = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}

		bw.write(solve(s) + "\n");

		bw.flush();

	}

	public static int solve(String[] s) {
		int result = 0;
		for (int i = 1; i < s.length; i++) {
			if (isSimilar(s[0], s[i])) {
				result++;
			}
		}

		return result;
	}

	public static String sSort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	public static boolean isSimilar(String a, String b) {
		if (a.length() - b.length() > 1 || a.length() - b.length() < -1) {
			return false;
		}

		String big = a.length() > b.length() ? sSort(a) : sSort(b);
		String small = a.length() > b.length() ? sSort(b) : sSort(a);

		if (big.length() == small.length()) {
			for (int i = 0; i < small.length(); i++) {
				for (char c = 'A'; c <= 'Z'; c++) {
					String temp = sSort(small.substring(0, i) + c + small.substring(i + 1));
					if (big.equals(temp)) {
						return true;
					}
				}
			}
		} else {
			for (int i = 0; i < small.length() + 1; i++) {
				for (char c = 'A'; c <= 'Z'; c++) {
					String temp = sSort(small.substring(0, i) + c + small.substring(i));
					if (big.equals(temp)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}