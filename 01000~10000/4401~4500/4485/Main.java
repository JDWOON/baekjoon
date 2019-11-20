import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		int cnt = 1;

		while (n > 0) {
			int[][] cave = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write("Problem " + cnt + ": " + solve(cave) + "\n");

			cnt++;
			n = Integer.parseInt(br.readLine());
		}

		bw.flush();
	}

	public static int solve(int[][] cave) throws IOException {
		int[][] p = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(p[i], Integer.MAX_VALUE);
		}

		p[0][0] = cave[0][0];

		getMin(cave, p);

		return p[n - 1][n - 1];
	}

	public static void getMin(int[][] cave, int[][] p) {
		boolean check = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = Integer.MAX_VALUE;

				if (i > 0 && p[i - 1][j] != Integer.MAX_VALUE) {
					temp = Math.min(temp, p[i - 1][j] + cave[i][j]);
				}
				if (i < n - 1 && p[i + 1][j] != Integer.MAX_VALUE) {
					temp = Math.min(temp, p[i + 1][j] + cave[i][j]);

				}
				if (j > 0 && p[i][j - 1] != Integer.MAX_VALUE) {
					temp = Math.min(temp, p[i][j - 1] + cave[i][j]);
				}
				if (j < n - 1 && p[i][j + 1] != Integer.MAX_VALUE) {
					temp = Math.min(temp, p[i][j + 1] + cave[i][j]);
				}

				if (temp < p[i][j]) {
					p[i][j] = temp;
					check = true;
				}
			}
		}

		if (check) {
			getMin(cave, p);
		}
	}
}