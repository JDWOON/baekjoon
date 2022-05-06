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
		int[][] p = new int[n][n];

		int[] result = new int[] { 0, 0 };

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(p, n, 0, 0, result);

		bw.write(result[0] + "\n" + result[1] + "\n");
		bw.flush();
	}

	public static void solve(int[][] p, int size, int x, int y, int[] result) {
		boolean check = true;

		for (int i = 0; i < size && check; i++) {
			for (int j = 0; j < size && check; j++) {
				if (p[x][y] != p[x + i][y + j]) {
					check = false;
				}
			}
		}

		if (check) {
			if (p[x][y] == 1) {
				result[1]++;
			} else {
				result[0]++;
			}
		} else {
			solve(p, size / 2, x, y, result);
			solve(p, size / 2, x + (size / 2), y, result);
			solve(p, size / 2, x, y + (size / 2), result);
			solve(p, size / 2, x + (size / 2), y + (size / 2), result);
		}
	}
}