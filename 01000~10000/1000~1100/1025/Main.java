import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] list = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				list[i][j] = s.charAt(j);
			}
		}

		bw.write(solve(list, n, m) + "\n");
		bw.flush();
	}

	public static int solve(char[][] list, int n, int m) {
		int result = -1;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				for (int dx = -n; dx < n; dx++) {
					for (int dy = -m; dy < m; dy++) {
						String s = new String();
						int a = x, b = y;

						if (dx != 0 || dy != 0) {
							while (a > -1 && b > -1 && a < n && b < m) {
								s += list[a][b];
								a += dx;
								b += dy;

								int now = Integer.parseInt(s);
								if (isTwice(now) && now > result) {
									result = now;
								}
							}
						}
					}
				}
			}
		}

		return result;
	}

	public static boolean isTwice(int n) {
		for (int i = 0; i * i <= n; i++) {
			if (i * i == n) {
				return true;
			}
		}
		return false;
	}
}