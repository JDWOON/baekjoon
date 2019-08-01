import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (op == 0) {
				union(a, b);
			} else if (op == 1) {
				String result = find(a) == find(b) ? "YES" : "NO";
				bw.write(result + "\n");
			}
		}

		bw.flush();
	}

	public static int find(int a) {
		if (list[a] == a) {
			return a;
		} else {
			list[a] = find(list[a]);
			return list[a];
		}
	}

	public static void union(int a, int b) {
		list[find(b)] = list[find(a)];
	}
}
