import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] list;
	public static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bw.write(solve(n, m, k) + "");

		bw.flush();
	}

	public static int solve(int n, int m, int k) {
		int max = 0;

		for (int i = 0; i <= k; i++) {
			int a = n - i;
			int b = m - k + i;

			max = Math.max(max, Math.min(a / 2, b));
		}

		return max;
	}
}