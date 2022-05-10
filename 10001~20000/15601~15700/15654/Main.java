import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		solve(a, n, m, new LinkedList<Integer>(), new boolean[n]);

		bw.flush();
	}

	public static void solve(int[] a, int n, int m, LinkedList<Integer> list, boolean[] isVisit) throws IOException {
		if (list.size() == m) {
			for (int val : list) {
				bw.write(a[val] + " ");
			}
			bw.write("\n");
		} else {
			for (int i = 0; i < n; i++) {
				if (!isVisit[i]) {
					isVisit[i] = true;
					list.add(i);
					solve(a, n, m, list, isVisit);
					list.removeLast();
					isVisit[i] = false;
				}
			}
		}
	}
}