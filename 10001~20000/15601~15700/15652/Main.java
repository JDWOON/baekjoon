import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		solve(n, m, 0, new int[m]);

		bw.flush();
	}

	public static void solve(int n, int m, int depth, int[] list) throws IOException {
		if (depth == m) {
			for (int val : list) {
				bw.write(val + " ");
			}
			bw.write("\n");
		} else {
			int prev = depth == 0 ? 1 : list[depth - 1];

			for (int i = prev; i <= n; i++) {
				list[depth] = i;
				solve(n, m, depth + 1, list);
			}
		}
	}
}
