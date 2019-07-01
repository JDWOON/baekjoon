import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int n, m;
	static int[][] list;
	static int[] listSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		n = 10000;
//		m = 100000;

		listSize = new int[n];
		Arrays.fill(listSize, 0);
		list = new int[n][];
		for (int i = 0; i < n; i++) {
			list[i] = new int[5];
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

//			int a = 0, b = 0;
//			while (a == b || checkContains(a, b)) {
//				a = (int) (Math.random() * n);
//				b = (int) (Math.random() * n);
//			}

			if (listSize[b] == list[b].length) {
				list[b] = Arrays.copyOf(list[b], list[b].length + 10);
			}

			list[b][listSize[b]] = a;
			listSize[b]++;
		}

		for (int i : solve()) {
			bw.write((i + 1) + " ");
		}

		bw.flush();
	}

	public static boolean checkContains(int a, int b) {
		for (int i = 0; i < listSize[b]; i++) {
			if (list[b][i] == a) {
				return true;
			}
		}
		return false;
	}

	static boolean[] visit;
	static int cnt;

	public static ArrayList<Integer> solve() {
		int maxVal = 0;
		ArrayList<Integer> maxList = new ArrayList<Integer>();

		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(visit, false);
			cnt = 0;

			dfs(i);

			if (cnt > maxVal) {
				maxVal = cnt;
				maxList.clear();
				maxList.add(i);
			} else if (cnt == maxVal) {
				maxList.add(i);
			}
		}

		return maxList;
	}

	public static void dfs(int now) {
		cnt++;
		visit[now] = true;

		for (int i = 0; i < listSize[now]; i++) {
			if (!visit[list[now][i]]) {
				dfs(list[now][i]);
			}
		}
	}
}