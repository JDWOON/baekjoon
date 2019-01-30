import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] board = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.next();

			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == 'W') {
					board[i][j] = false;
				} else {
					board[i][j] = true;
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int cnt = 0;
				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						if ((x + y) % 2 == 0 && board[i + x][j + y]) {
							cnt++;
						} else if ((x + y) % 2 == 1 && !board[i + x][j + y]) {
							cnt++;
						}
					}
				}
				cnt = Math.min(cnt, 64 - cnt);
				min = Math.min(min, cnt);
			}
		}

		System.out.println(min);
	}
}