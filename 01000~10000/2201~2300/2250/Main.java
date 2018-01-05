package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int[] left = new int[n + 1];
		int[] right = new int[n + 1];
		int[] par = new int[n + 1];
		Arrays.fill(par, 0);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int temp = Integer.parseInt(st.nextToken());
			left[temp] = Integer.parseInt(st.nextToken());
			right[temp] = Integer.parseInt(st.nextToken());
			if (left[temp] > 0) {
				par[left[temp]] = temp;
			}
			if (right[temp] > 0) {
				par[right[temp]] = temp;
			}
		}

		int root = n / 2 + 1;

		while (par[root] > 0) {
			root = par[root];
		}

		int[] y = new int[n + 1];
		new Main().getY(left, right, y, root, 1);
		ArrayList<Integer> x = new Main().getX(left, right, root);
		int[] start = new int[y[0] + 1];
		int[] width = new int[y[0] + 1];
		Arrays.fill(start, -1);
		Arrays.fill(width, 1);

		for (int i = 0; i < x.size(); i++) {
			if (start[y[x.get(i)]] < 0) {
				start[y[x.get(i)]] = i;
			} else {
				width[y[x.get(i)]] = i - start[y[x.get(i)]] + 1;
			}
		}

		int line = 1;
		for (int i = 2; i < width.length; i++) {
			if (width[i] > width[line]) {
				line = i;
			}
		}

		System.out.println(line + " " + width[line]);

	}

	public ArrayList<Integer> getX(int[] left, int[] right, int root) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		if (left[root] > 0) {
			x.addAll(getX(left, right, left[root]));
		}
		x.add(root);
		if (right[root] > 0) {
			x.addAll(getX(left, right, right[root]));
		}
		return x;
	}

	public void getY(int[] left, int[] right, int[] y, int root, int nowY) {
		y[root] = nowY;
		y[0] = Math.max(y[0], y[root]);
		if (left[root] > 0) {
			getY(left, right, y, left[root], nowY + 1);
		}
		if (right[root] > 0) {
			getY(left, right, y, right[root], nowY + 1);
		}
	}
}