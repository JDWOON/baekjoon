import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] list;
	public static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);

		bw.write(solve(a, visit, k, 0, 0) + "");

		bw.flush();
	}

	public static int solve(int[] a, boolean[] visit, int k, int now, int cnt) {
		if (visit[now]) {
			return -1;
		} else if (now == k) {
			return cnt;
		} else {
			visit[now] = true;

			return solve(a, visit, k, a[now], cnt + 1);
		}
	}
}