import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		int max = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = 1; i + x < n && j + x < m; x++) {
					if (board[i][j] == board[i + x][j] && board[i][j] == board[i][j + x]
							&& board[i][j] == board[i + x][j + x]) {
						max = Math.max(max, x + 1);
					}
				}
			}
		}
		System.out.println(max * max);
	}
}