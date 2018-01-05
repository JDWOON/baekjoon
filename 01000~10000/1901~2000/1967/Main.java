package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> child = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> val = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n + 1; i++) {
			child.add(new ArrayList<Integer>());
			val.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int par = Integer.parseInt(st.nextToken());
			child.get(par).add(Integer.parseInt(st.nextToken()));
			val.get(par).add(Integer.parseInt(st.nextToken()));
		}

		System.out.println(new Main().solve(child, val, 1));
	}

	public int solve(ArrayList<ArrayList<Integer>> child, ArrayList<ArrayList<Integer>> val, int root) {
		if (child.get(root).size() < 2) {
			int max = childMax(child, val, root);
			for (int i = 0; i < child.get(root).size(); i++) {
				max = Math.max(max, solve(child, val, child.get(root).get(i)));
			}
			return max;
		} else {
			int left = 0, right = -1;
			for (int i = 1; i < child.get(root).size(); i++) {
				if (val.get(root).get(left) < val.get(root).get(i)) {
					right = left;
					left = i;
				} else if (right < 0 || val.get(root).get(right) < val.get(root).get(i)) {
					right = i;
				}
			}
			int max = childMax(child, val, child.get(root).get(left)) + childMax(child, val, child.get(root).get(right))
					+ val.get(root).get(left) + val.get(root).get(right);

			for (int i = 0; i < child.get(root).size(); i++) {
				max = Math.max(max, solve(child, val, child.get(root).get(i)));
			}

			return max;
		}
	}

	public int childMax(ArrayList<ArrayList<Integer>> child, ArrayList<ArrayList<Integer>> val, int root) {
		if (child.get(root).isEmpty()) {
			return 0;
		} else {
			int max = 0;
			for (int i = 0; i < child.get(root).size(); i++) {
				int ch = child.get(root).get(i);
				max = Math.max(max, childMax(child, val, ch) + val.get(root).get(i));
			}
			return max;
		}
	}
}