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

		bw.write(solve(n, m) + "\n");
		bw.flush();
	}

	public static String solve(int n, int m) {
		StringBuilder sb = new StringBuilder();

		int size = (int) Math.pow(n, m);

		for (int i = 0; i < size; i++) {
			int[] seq = new int[m];
			int now = i;

			for (int j = 0; j < m; j++) {
				seq[j] = (now % n) + 1;
				now /= n;
			}

			for (int j = m - 1; j > 0; j--) {
				sb.append(seq[j] + " ");
			}
			sb.append(seq[0] + "\n");
		}

		return sb.toString();
	}
}
