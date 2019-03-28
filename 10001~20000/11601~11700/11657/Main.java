import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private final static int MAX_TIME = 500 * 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, c);
		}

		int[] result = new int[n];
		Arrays.fill(result, MAX_TIME);
		result[0] = 0;

		solve(edges, result);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (result[0] == -1) {
			bw.write(-1 + "\n");
		} else {
			for (int i = 1; i < result.length; i++) {
				if (result[i] == MAX_TIME) {
					bw.write(-1 + "\n");
				} else {
					bw.write(result[i] + "\n");
				}
			}
		}

		bw.flush();
	}

	public static void solve(Edge[] edges, int[] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (result[edges[j].source] < MAX_TIME
						&& result[edges[j].dest] > result[edges[j].source] + edges[j].weight) {
					result[edges[j].dest] = result[edges[j].source] + edges[j].weight;
				}
			}
		}

		for (int i = 0; i < edges.length; i++) {
			if (result[edges[i].source] < MAX_TIME
					&& result[edges[i].dest] > result[edges[i].source] + edges[i].weight) {
				result[0] = -1;
				return;
			}
		}
	}

	public static class Edge {
		int source;
		int dest;
		int weight;

		Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
}
