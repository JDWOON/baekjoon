package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public final static int mod = 1000000007;
	public static long[] rootDP = new long[100001];
	public static long[] endDP = new long[100001];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> weight = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
			weight.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
			weight.get(a).add(c);
			weight.get(b).add(c);
		}

		int root = 1;
		Arrays.fill(rootDP, -1);
		Arrays.fill(endDP, -1);
		new Main().removeParent(root, 0);
		System.out.println(new Main().rootSolve(root));
	}

	public long rootSolve(int root) {
		if (rootDP[root] != -1) {
			return rootDP[root];
		} else if (list.get(root).size() == 0) {
			rootDP[root] = 0;
			return rootDP[root] = 0;
		} else {
			rootDP[root] = endSolve(root);
			long sum = 0;
			long sq = 0;
			for (int i = 0; i < list.get(root).size(); i++) {
				rootDP[root] += rootSolve(list.get(root).get(i));
				long temp = ((endSolve(list.get(root).get(i)) + 1) * weight.get(root).get(i)) % mod;
				sum = (sum + temp) % mod;
				sq = (sq + (temp * temp)) % mod;
			}

			rootDP[root] += (((mod + sum * sum - sq) % mod) * 500000004) % mod;
			// rootDP[root] += (((sum * sum - sq)/2) % mod) % mod;
			rootDP[root] = rootDP[root] % mod;
			return rootDP[root];
		}
	}

	public long endSolve(int root) {
		if (endDP[root] != -1) {
			return endDP[root];
		} else if (list.get(root).size() == 0) {
			endDP[root] = 0;
			return endDP[root];
		} else {
			endDP[root] = 0;
			for (int i = 0; i < list.get(root).size(); i++) {
				endDP[root] += (endSolve(list.get(root).get(i)) + 1) * weight.get(root).get(i);
				endDP[root] = endDP[root] % mod;
			}
			return endDP[root];
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
}