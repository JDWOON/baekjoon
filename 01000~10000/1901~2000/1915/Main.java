import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n = 0, m = 0;
	static int[][] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				p[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static int solve() {
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i > 0 && j > 0 && p[i][j] > 0) {
					p[i][j] += Math.min(p[i - 1][j], Math.min(p[i][j - 1], p[i - 1][j - 1]));
				}

				result = Math.max(result, p[i][j]);
			}
		}

		return result * result;
	}
}
