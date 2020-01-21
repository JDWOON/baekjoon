import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static boolean isFinish = false;

	public static void main(String[] args) throws IOException {
		int[][] board = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					list.add(i * j);
				}
			}
		}

		solve(board);
		printBoard(board);
	}

	public static void printBoard(int[][] board) throws IOException {
		for (int i = 0; i < 9; i++) {
			String line = Arrays.toString(board[i]).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "");
			bw.write(line + "\n");
		}
		bw.flush();
	}

	public static void solve(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = k;
						if (isValid(board, i, j)) {
							solve(board);

							if (isFinish) {
								return;
							}
						}
						board[i][j] = 0;
					}
					return;
				}
			}
		}

		isFinish = true;
	}

	public static boolean isValid(int[][] board, int x, int y) {
		boolean[] isExist = new boolean[10];

		Arrays.fill(isExist, false);
		for (int i = 0; i < 9; i++) {
			if (board[x][i] > 0 && isExist[board[x][i]]) {
				return false;
			}
			isExist[board[x][i]] = true;
		}

		Arrays.fill(isExist, false);
		for (int i = 0; i < 9; i++) {
			if (board[i][y] > 0 && isExist[board[i][y]]) {
				return false;
			}
			isExist[board[i][y]] = true;
		}

		Arrays.fill(isExist, false);
		int left = (x / 3) * 3, top = (y / 3) * 3;
		for (int i = 0; i < 9; i++) {
			int nowX = left + (i % 3);
			int nowY = top + (i / 3);

			if (board[nowX][nowY] > 0 && isExist[board[nowX][nowY]]) {
				return false;
			}
			isExist[board[nowX][nowY]] = true;
		}

		return true;
	}
}
