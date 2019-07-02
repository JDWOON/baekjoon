import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			long[] x = new long[n], y = new long[n];

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				x[j] = Long.parseLong(st.nextToken());
				y[j] = Long.parseLong(st.nextToken());
			}

			bw.write(solve(x, y, 0, 0, 0, 0) + "\n");
		}

		bw.flush();
	}

	public static double solve(long[] x, long[] y, int now, int mCnt, long sumX, long sumY) {
		if (x.length / 2 == mCnt) {
			for (int i = now; i < x.length; i++) {
				sumX += x[i];
				sumY += y[i];
			}

			return Math.sqrt((double) sumX * sumX + sumY * sumY);
		} else if (x.length / 2 == now - mCnt) {
			for (int i = now; i < x.length; i++) {
				sumX -= x[i];
				sumY -= y[i];
			}

			return Math.sqrt((double) sumX * sumX + sumY * sumY);
		} else {
			double a = solve(x, y, now + 1, mCnt, sumX + x[now], sumY + y[now]);
			double b = solve(x, y, now + 1, mCnt + 1, sumX - x[now], sumY - y[now]);

			return Math.min(a, b);
		}
	}
}