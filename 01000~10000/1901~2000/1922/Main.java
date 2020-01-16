import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int[][] p = new int[n][n];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			p[a][b] = c;
			p[b][a] = c;
		}

		bw.write(solve(p) + "\n");
		bw.flush();
	}

	public static int solve(int[][] p) {
		int now = 0, result = 0;

		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);
		visit[0] = true;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int cnt = 1; cnt < n; cnt++) {
			for (int i = 0; i < n; i++) {
				if (!visit[i] && p[now][i] > 0) {
					if (!map.containsKey(i)) {
						map.put(i, p[now][i]);
					} else if (map.get(i) > p[now][i]) {
						map.put(i, p[now][i]);
					}
				}
			}

			int next = -1;

			for (Entry<Integer, Integer> e : map.entrySet()) {
				if (next == -1 || map.get(next) > e.getValue()) {
					next = e.getKey();
				}
			}

			result += map.get(next);
			map.remove(next);
			visit[next] = true;
			now = next;
		}

		return result;
	}
}
