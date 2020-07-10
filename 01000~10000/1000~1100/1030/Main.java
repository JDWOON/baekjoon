import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				bw.write("" + solve(s, n, k, i, j));
			}
			bw.write("\n");
		}
		bw.flush();
	}

	public static int solve(int s, int n, int k, int x, int y) {
		if (s == 0) {
			return 0;
		} else {
			int prev = pow(n, s - 1);
			int start = (n - k) / 2 * prev;
			int end = pow(n, s) - start;

			if (x >= start && x < end && y >= start && y < end) {
				return 1;
			} else {
				return solve(s - 1, n, k, x % prev, y % prev);
			}
		}
	}

	public static int pow(int a, int b) {
		int result = 1;
		for (int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
}