import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int rSize, cSize, m;
	static Shark[] sh;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		rSize = Integer.parseInt(st.nextToken());
		cSize = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		sh = new Shark[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sh[i] = new Shark(r, c, s, d, z);
		}

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static int solve() {
		int result = 0;

		int now = -1;

		int[][] board = new int[rSize][cSize];

		while (now < cSize - 1) {
			now++;

			for (int i = 0; i < rSize; i++) {
				Arrays.fill(board[i], -1);
			}

			for (int i = 0; i < m; i++) {
				if (sh[i].alive) {
					int r = sh[i].r;
					int c = sh[i].c;

					if (board[r][c] == -1) {
						board[r][c] = i;
						sh[i].next();
					} else if (sh[board[r][c]].z < sh[i].z) {
						sh[board[r][c]].alive = false;
						board[r][c] = i;
						sh[i].next();
					} else {
						sh[i].alive = false;
					}
				}
			}

			int idx = -1;

			for (int i = 0; i < rSize; i++) {
				if (board[i][now] >= 0) {
					idx = board[i][now];
					sh[idx].alive = false;
					break;
				}
			}

			if (idx >= 0) {
				result += sh[idx].z;
			}
		}

		return result;
	}

	public static class Shark {
		int r, c, s, d, z;
		boolean alive = true;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = d <= 2 ? s % (rSize * 2 - 2) : s % (cSize * 2 - 2);
			this.d = d;
			this.z = z;
		}

		public void next() {
			if (alive) {
				int f = d <= 2 ? (rSize - 1) * 2 : (cSize - 1) * 2;
				int temp;
				switch (d) {
				case 1:
					temp = (f - r + s) % f;
					if (temp < rSize - 1) {
						d = 2;
						r = temp;
					} else {
						r = f - temp;
					}
					break;
				case 2:
					temp = (r + s) % f;
					if (temp < rSize - 1) {
						r = temp;
					} else {
						d = 1;
						r = f - temp;
					}
					break;
				case 3:
					temp = (c + s) % f;
					if (temp < cSize - 1) {
						c = temp;
					} else {
						d = 4;
						c = f - temp;
					}
					break;
				case 4:
					temp = (f - c + s) % f;
					if (temp < cSize - 1) {
						d = 3;
						c = temp;
					} else {
						c = f - temp;
					}
					break;
				}
			}
		}
	}
}
