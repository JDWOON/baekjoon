package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] map = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = '.';
			}
		}

		System.out.println(new Main().solve(map, n, 0));

	}

	public int solve(char[][] map, int n, int now) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			boolean check = true;

			for (int j = 0; j < now; j++) {
				if (map[i][j] == 'Q') {
					check = false;
					break;
				}
			}

			int x = i, y = now;

			while (check && x > 0 && y > 0) {
				x--;
				y--;
				if (map[x][y] == 'Q') {
					check = false;
					break;
				}
			}

			x = i;
			y = now;

			while (check && x < n - 1 && y > 0) {
				x++;
				y--;
				if (map[x][y] == 'Q') {
					check = false;
					break;
				}
			}

			if (check) {
				if (now == n - 1) {
					result++;
				} else {
					map[i][now] = 'Q';
					result += solve(map, n, now + 1);
					map[i][now] = '.';
				}
			}
		}

		return result;
	}
}