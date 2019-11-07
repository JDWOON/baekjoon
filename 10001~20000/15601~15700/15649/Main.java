import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		solve(n, m, new LinkedList<Integer>());
		bw.flush();
	}

	public static void solve(int n, int m, LinkedList<Integer> list) throws IOException {
		if (list.size() == m) {
			for (int i : list) {
				bw.write(i + " ");
			}
			bw.write("\n");
		} else {
			for (int i = 1; i < n + 1; i++) {
				if (!list.contains(i)) {
					list.add(i);
					solve(n, m, list);
					list.removeLast();
				}
			}
		}
	}
}