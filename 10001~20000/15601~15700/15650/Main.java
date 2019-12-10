import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[n + 1];
		Arrays.fill(visit, false);

		dfs(visit, 1, 0);

		bw.flush();
	}

	public static void dfs(boolean[] visit, int now, int cnt) throws IOException {
		if (cnt == m) {
			for (int i = 1; i < n + 1; i++) {
				if (visit[i]) {
					bw.write(i + " ");
				}
			}
			bw.write("\n");
		} else if (now < n + 1 && cnt < m) {
			visit[now] = true;
			dfs(visit, now + 1, cnt + 1);
			visit[now] = false;
			dfs(visit, now + 1, cnt);
		}
	}
}