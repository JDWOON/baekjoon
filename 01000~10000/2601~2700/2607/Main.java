import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		bw.write(solve(words) + "\n");
		bw.flush();
	}

	public static int solve(String[] words) {
		int result = 0;
		int[] std = getCount(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (similar(std, getCount(words[i]))) {
				result++;
			}
		}

		return result;
	}

	public static int[] getCount(String s) {
		int[] cnt = new int[(int) ('Z' - 'A' + 1)];
		Arrays.fill(cnt, 0);

		for (int i = 0; i < s.length(); i++) {
			cnt[(int) (s.charAt(i) - 'A')]++;
		}

		return cnt;
	}

	public static boolean similar(int[] a, int[] b) {
		int sum = 0, cnt = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				cnt++;
				sum += a[i] - b[i];
			}
		}

		if (cnt == 0) {
			return true;
		} else if (cnt == 1) {
			return sum == 1 || sum == -1;
		} else if (cnt == 2) {
			return sum == 0;
		} else {
			return false;
		}
	}
}
