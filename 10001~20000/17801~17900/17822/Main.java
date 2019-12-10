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
	static int n, m;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] p = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			rotate(p, x, d, k);

			erase(p);
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (p[i][j] > 0) {
					result += p[i][j];
				}
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}

	public static void rotate(int[][] p, int x, int d, int k) {
		if (d == 0) {
			k = m - k;
		}

		for (int i = x - 1; i < p.length; i += x) {
			int[] temp = new int[m];
			for (int j = 0; j < m; j++) {
				temp[j] = p[i][j];
			}

			for (int j = 0; j < m; j++) {
				p[i][j] = temp[(j + k) % m];
			}
		}
	}

	public static void erase(int[][] p) {
		int[][] temp = new int[n][m];
		int sum = 0, cnt = 0;
		boolean check = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = p[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] > 0) {
					sum += temp[i][j];
					cnt++;

					if (temp[i][j] == temp[i][(j + 1) % m]) {
						check = true;
						p[i][j] = -1;
						p[i][(j + 1) % m] = -1;
					}
					if (temp[i][j] == temp[i][(j - 1 + m) % m]) {
						check = true;
						p[i][j] = -1;
						p[i][(j - 1 + m) % m] = -1;
					}
					if (i < n - 1 && temp[i][j] == temp[i + 1][j]) {
						check = true;
						p[i][j] = -1;
						p[i + 1][j] = -1;
					}
					if (i > 0 && temp[i][j] == temp[i - 1][j]) {
						check = true;
						p[i][j] = -1;
						p[i - 1][j] = -1;
					}
				}
			}
		}

		if (!check) {
			double avr = ((double) sum) / ((double) cnt);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (p[i][j] > 0) {
						if ((double) p[i][j] > avr) {
							p[i][j] = p[i][j] - 1;
						} else if ((double) p[i][j] < avr) {
							p[i][j] = p[i][j] + 1;
						}
					}
				}
			}
		}
	}
}