import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] a = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());

				if (j > 0 && i > 0) {
					a[i][j] += a[i][j - 1] + a[i - 1][j] - a[i - 1][j - 1];
				} else if (i > 0) {
					a[i][j] += a[i - 1][j];
				} else if (j > 0) {
					a[i][j] += a[i][j - 1];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int result = a[x2][y2];

			if (x1 > 0 && y1 > 0) {
				result += a[x1 - 1][y1 - 1] - a[x1 - 1][y2] - a[x2][y1 - 1];
			} else if (x1 > 0) {
				result -= a[x1 - 1][y2];
			} else if (y1 > 0) {
				result -= a[x2][y1 - 1];
			}

			bw.write(result + "\n");
		}

		bw.flush();
	}
}