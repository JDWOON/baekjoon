import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] a;
	static int[] r, c, s;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		a = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		r = new int[k];
		c = new int[k];
		s = new int[k];
		check = new boolean[k];
		Arrays.fill(check, false);

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken()) - 1;
			c[i] = Integer.parseInt(st.nextToken()) - 1;
			s[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(a, 0) + "\n");

		bw.flush();
	}

	public static int solve(int[][] now, int cnt) {
		if (cnt == k) {
			return getMin(now);
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < k; i++) {
			if (!check[i]) {
				check[i] = true;
				result = Math.min(result, solve(getRotateArr(now, r[i], c[i], s[i]), cnt + 1));
				check[i] = false;
			}
		}

		return result;
	}

	public static int[][] getRotateArr(int[][] origin, int r, int c, int s) {
		int[][] result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = origin[i][j];
			}
		}

		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= 2 * i; j++) {
				result[r - i][c - i + j] = origin[r - i][c - i + j - 1];
				result[r + i - j][c - i] = origin[r + i - j + 1][c - i];
				result[r + i][c + i - j] = origin[r + i][c + i - j + 1];
				result[r - i + j][c + i] = origin[r - i + j - 1][c + i];
			}
		}

		return result;
	}

	public static int getMin(int[][] arr) {
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int temp = 0;

			for (int j = 0; j < arr[i].length; j++) {
				temp += arr[i][j];
			}

			result = Math.min(result, temp);
		}

		return result;
	}
}
