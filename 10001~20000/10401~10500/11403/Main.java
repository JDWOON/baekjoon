import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] m = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			solve(m, i, i, result);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}

	public static void solve(int[][] m, int start, int now, int[][] result) {
		for (int i = 0; i < m.length; i++) {
			if (m[now][i] == 1 && result[start][i] == 0) {
				result[start][i] = 1;
				solve(m, start, i, result);
			}
		}
	}
}