package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int root = 1;
		new Main().removeParent(list, root, 0);

		int[][] dp = new int[n + 1][(int) (Math.log(n) / Math.log(2)) + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < dp[root].length; i++) {
			min = Math.min(min, new Main().getVal(list, dp, root, i));
		}
		System.out.println(min);
	}

	public void removeParent(ArrayList<ArrayList<Integer>> list, int root, int par) {
		list.get(root).remove(new Integer(par));
		for (int i = 0; i < list.get(root).size(); i++) {
			removeParent(list, list.get(root).get(i), root);
		}
	}

	public int getVal(ArrayList<ArrayList<Integer>> list, int[][] dp, int root, int color) {
		if (dp[root][color] != -1) {
			return dp[root][color];
		} else if (list.get(root).isEmpty()) {
			for (int i = 1; i < dp[root].length; i++) {
				dp[root][i] = i;
			}
			return dp[root][color];
		} else {
			int val = 0;
			for (int i = 0; i < list.get(root).size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 1; j < dp[root].length; j++) {
					if (j != color) {
						temp = Math.min(temp, getVal(list, dp, list.get(root).get(i), j));
					}
				}
				val += temp;
			}
			dp[root][color] = val + color;
			return dp[root][color];
		}
	}
}