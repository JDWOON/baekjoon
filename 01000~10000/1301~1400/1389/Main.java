import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			list[a].add(b);
			list[b].add(a);
		}

		int[][] k = new int[n][n];

		for (int i = 0; i < n; i++) {
			getK(list, k, i, i, 0);
		}

		bw.write(solve(k) + "\n");

		bw.flush();
	}

	public static void getK(ArrayList<Integer>[] list, int[][] k, int start, int now, int cnt) {
		if (k[start][now] == 0 || k[start][now] > cnt) {
			k[start][now] = cnt;

			for (int next : list[now]) {
				if (next != start) {
					getK(list, k, start, next, cnt + 1);
				}
			}
		}
	}

	public static int solve(int[][] k) {
		int result = 0, sum = Integer.MAX_VALUE;

		for (int i = 0; i < k.length; i++) {
			int temp = 0;

			for (int j = 0; j < k.length; j++) {
				temp += k[i][j];
			}

			if (temp < sum) {
				result = i;
				sum = temp;
			}
		}

		return result + 1;
	}
}