import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] cost = new int[n][n];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if (cost[a][b] == 0 || cost[a][b] > c) {
				cost[a][b] = c;
			}
		}

		for (int mid = 0; mid < n; mid++) {
			for (int start = 0; start < n; start++) {
				for (int end = 0; end < n; end++) {
					if (start == end || cost[start][mid] == 0 || cost[mid][end] == 0) {
						continue;
					} else if (cost[start][end] == 0 || cost[start][end] > cost[start][mid] + cost[mid][end]) {
						cost[start][end] = cost[start][mid] + cost[mid][end];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(cost[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}
}