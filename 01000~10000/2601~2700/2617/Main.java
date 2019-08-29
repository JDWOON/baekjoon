import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Ball[] balls = new Ball[n + 1];
		for (int i = 1; i < n + 1; i++) {
			balls[i] = new Ball(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			balls[a].left.add(balls[b]);
			balls[b].right.add(balls[a]);
		}

		int result = 0;

		for (int i = 1; i < n + 1; i++) {
			int lCnt = balls[i].count(false);
			int rCnt = balls[i].count(true);

			if (lCnt >= (n + 1) / 2 || rCnt >= (n + 1) / 2) {
				result++;
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}

	public static class Ball {
		int val;
		ArrayList<Ball> left = new ArrayList<Ball>();
		ArrayList<Ball> right = new ArrayList<Ball>();

		Ball(int val) {
			this.val = val;
		}

		public int count(boolean rightMode) {
			boolean[] visit = new boolean[n + 1];
			Arrays.fill(visit, false);
			visit[val] = true;

			int result = 0;

			for (Ball next : rightMode ? right : left) {
				if (!visit[next.val]) {
					result += dfsCount(visit, next, rightMode);
				}
			}

			return result;
		}

		private int dfsCount(boolean[] visit, Ball now, boolean rightMode) {
			if (visit[now.val]) {
				return 0;
			} else {
				visit[now.val] = true;

				int result = 1;

				for (Ball next : rightMode ? now.right : now.left) {
					if (!visit[next.val]) {
						result += dfsCount(visit, next, rightMode);
					}
				}

				return result;
			}
		}
	}
}
