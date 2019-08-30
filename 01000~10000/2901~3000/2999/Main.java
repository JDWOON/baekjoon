import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		bw.write(solve(s) + "\n");
		bw.flush();
	}

	public static String solve(String s) {
		int n = s.length();
		int r = 1, c = n;

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				if (i <= n / i) {
					r = i;
					c = n / i;
				} else {
					break;
				}
			}
		}

		char[][] mat = new char[r][c];

		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				mat[i][j] = s.charAt(i + (j * r));
			}
		}

		String result = new String();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result += mat[i][j];
			}
		}

		return result;
	}
}
