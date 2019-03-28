import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] edges = new ArrayList[n + 1];
		int[] result = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			edges[i] = new ArrayList<Integer>();
			result[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edges[a].add(b);
		}

		for (int i = 1; i < n + 1; i++) {
			boolean[] visit = new boolean[n + 1];
			Arrays.fill(visit, false);

			solve(edges, visit, result, i);
		}

		int maxHack = 0;
		for (int i = 1; i < n + 1; i++) {
			maxHack = Math.max(maxHack, result[i]);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i < n + 1; i++) {
			if (result[i] == maxHack) {
				bw.write(i + " ");
			}
		}

		bw.flush();
	}

	public static void solve(ArrayList<Integer>[] edges, boolean[] visit, int[] result, int now) {
		if (visit[now]) {
			return;
		} else {
			visit[now] = true;
			result[now]++;
			for (int prev : edges[now]) {
				if (!visit[prev]) {
					solve(edges, visit, result, prev);
				}
			}
		}
	}
}
