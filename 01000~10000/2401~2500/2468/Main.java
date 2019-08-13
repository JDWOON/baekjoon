import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.write(solve() + "\n");

		bw.flush();
	}

	public static int solve() {
		int result = 1;

		for (int i = 1; i <= 100; i++) {
			boolean[][] board = getBoard(i);
			result = Math.max(result, getSafeCount(board));
		}

		return result;
	}

	public static int getSafeCount(boolean[][] board) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j]) {
					result++;
					visitArea(board, i, j);
				}
			}
		}

		return result;
	}

	public static void visitArea(boolean[][] board, int x, int y) {
		if (x > -1 && y > -1 && x < n && y < n && board[x][y]) {
			board[x][y] = false;
			visitArea(board, x + 1, y);
			visitArea(board, x - 1, y);
			visitArea(board, x, y + 1);
			visitArea(board, x, y - 1);
		}
	}

	public static boolean[][] getBoard(int h) {
		boolean[][] board = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = a[i][j] > h ? true : false;
			}
		}

		return board;
	}
}
