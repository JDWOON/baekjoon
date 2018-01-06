package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> weight = new ArrayList<ArrayList<Integer>>();
	public static int[] rootDP = new int[100001];
	public static int[] endDP = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int v = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < v + 1; i++) {
			list.add(new ArrayList<Integer>());
			weight.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			while (next != -1) {
				list.get(p).add(next);
				weight.get(p).add(Integer.parseInt(st.nextToken()));
				next = Integer.parseInt(st.nextToken());
			}
		}
		int root = 1;
		new Main().removeParent(root, 0);

		Arrays.fill(endDP, -1);
		Arrays.fill(rootDP, -1);

		System.out.println(new Main().rootSolve(root));
	}

	public int rootSolve(int root) {
		if (rootDP[root] != -1) {
			return rootDP[root];
		} else if (list.get(root).size() == 0) {
			rootDP[root] = 0;
			return rootDP[root];
		} else {
			rootDP[root] = 0;
			int idx1 = -1, idx2 = -1;
			int max1 = 0, max2 = 0;
			for (int i = 0; i < list.get(root).size(); i++) {
				int temp = endSolve(list.get(root).get(i)) + weight.get(root).get(i);
				if (idx1 == -1 || temp > max1) {
					idx2 = idx1;
					max2 = max1;
					idx1 = i;
					max1 = temp;
				} else if (idx2 == -1 || temp > endSolve(list.get(root).get(idx2)) + weight.get(root).get(idx2)) {
					idx2 = i;
					max2 = temp;
				}
				rootDP[root] = Math.max(rootDP[root], rootSolve(list.get(root).get(i)));
			}

			rootDP[root] = Math.max(rootDP[root], max1 + max2);
			return rootDP[root];
		}
	}

	public void removeParent(int root, int par) {
		int idx = list.get(root).indexOf(par);
		if (idx >= 0) {
			list.get(root).remove(idx);
			weight.get(root).remove(idx);
		}

		for (int i = 0; i < list.get(root).size(); i++) {
			removeParent(list.get(root).get(i), root);
		}
	}

	public int endSolve(int root) {
		if (endDP[root] != -1) {
			return endDP[root];
		} else if (list.get(root).size() == 0) {
			endDP[root] = 0;
			return endDP[root];
		} else {
			endDP[root] = 0;
			for (int i = 0; i < list.get(root).size(); i++) {
				endDP[root] = Math.max(endDP[root], endSolve(list.get(root).get(i)) + weight.get(root).get(i));
			}
			return endDP[root];
		}
	}
}