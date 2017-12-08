package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[144]; // 144 is 0 ~ 1024 size
		int cnt = 0;
		for (int i = 0; i < 1024; i++) {
			if (((i * 2) & i) == 0) {
				num[cnt] = i;
				cnt++;
			}
		}

		int c = sc.nextInt();

		for (int i = 0; i < c; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[][] room = new boolean[n][m];

			for (int j = 0; j < n; j++) {
				String temp = sc.next();
				for (int k = 0; k < m; k++) {
					if (temp.charAt(k) == '.') {
						room[j][k] = true;
					} else {
						room[j][k] = false;
					}
				}
			}
			System.out.println(new Main().solve(room, num));
		}
	}

	public int solve(boolean[][] room, int[] num) {
		int[] check = new int[room.length];

		for (int i = 0; i < room.length; i++) {
			check[i] = 0;
			for (int j = 0; j < room[0].length; j++) {
				check[i] *= 2;
				if (!room[i][j]) {
					check[i]++;
				}
			}
		}

		int[][] list = new int[room.length][];

		for (int i = 0; i < room.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < num.length && num[j] < (int) Math.pow(2, room[0].length); j++) {
				temp.add(num[j]);
			}
			list[i] = new int[temp.size()];
			for (int j = 0; j < temp.size(); j++) {
				list[i][j] = temp.get(j);
			}
		}

		int[][] dp = new int[10][1024];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 1024; j++) {
				dp[i][j] = 0;
			}
		}

		getMax(list, dp, check, 0, 0);

		int result = 0;
		for (int i = 0; i < 1024; i++) {
			result = Math.max(dp[room.length - 1][i], result);
		}

		return result;
	}

	public void getMax(int[][] list, int[][] dp, int[] check, int row, int before) {
		if (row == 0) {
			for (int i = 0; i < list[row].length; i++) {
				int now = list[row][i];
				if ((now & check[row]) == 0) {
					dp[row][now] = Integer.bitCount(now);
					if (row < list.length - 1) {
						getMax(list, dp, check, row + 1, now);
					}
				}
			}
		} else {
			for (int i = 0; i < list[row].length; i++) {
				int now = list[row][i];
				if ((now & check[row]) == 0 && match(before, now)) {
					if (dp[row - 1][before] + Integer.bitCount(now) < dp[row][now]) {
						continue;
					} else {
						dp[row][now] = dp[row - 1][before] + Integer.bitCount(now);
						if (row < list.length - 1) {
							getMax(list, dp, check, row + 1, now);
						}
					}
				}
			}
		}
	}

	public boolean match(int m, int n) {
		if ((m & (n * 2)) > 0 || (m & (n / 2)) > 0) {
			return false;
		} else {
			return true;
		}
	}
}