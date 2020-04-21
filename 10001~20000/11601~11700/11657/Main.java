import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static boolean isCircle = false;
	private final static int MAX_TIME = 500 * 10000;

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] v = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				v[i][j] = i == j ? 0 : MAX_TIME;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			v[a][b] = Math.min(v[a][b], c);
		}

		int[] result = new int[n];
		Arrays.fill(result, MAX_TIME);
		result[0] = 0;

		ArrayList<Integer> path = new ArrayList<Integer>();

		solve(v, result, path, 0, 0);

		if (isCircle) {
			bw.write("-1\n");
		} else {
			for (int i = 1; i < n; i++) {
				bw.write((result[i] == MAX_TIME ? -1 : result[i]) + "\n");
			}
		}

		bw.flush();
	}

	public static void solve(int[][] v, int[] result, ArrayList<Integer> path, int now, int time) {
		if (isCircle) {
			return;
		}

		for (int i = 0; i < v.length; i++) {
			if (v[now][i] != MAX_TIME && result[i] > time + v[now][i]) {
				if (path.contains(i)) {
					isCircle = true;
					return;
				} else {
					result[i] = time + v[now][i];
					path.add(now);
					solve(v, result, path, i, time + v[now][i]);
					path.remove(path.size() - 1);
				}
			}
		}
	}
}