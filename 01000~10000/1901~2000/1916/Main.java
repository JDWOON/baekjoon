import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		Map<Integer, Integer>[] bus = new Map[n];
		for (int i = 0; i < n; i++) {
			bus[i] = new HashMap<Integer, Integer>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if (!bus[a].containsKey(b) || bus[a].get(b) > c) {
				bus[a].put(b, c);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		bw.write(solve(bus, n, start, end) + "\n");

		bw.flush();
	}

	public static int solve(Map<Integer, Integer>[] bus, int n, int start, int end) {
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;

		PriorityQueue<CostInfo> pq = new PriorityQueue<CostInfo>(new Comparator<CostInfo>() {
			@Override
			public int compare(CostInfo o1, CostInfo o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});

		pq.add(new CostInfo(start, 0));

		while (pq.size() > 0) {
			CostInfo now = pq.poll();

			for (int next : bus[now.idx].keySet()) {
				if (now.cost + bus[now.idx].get(next) < cost[next]) {
					cost[next] = now.cost + bus[now.idx].get(next);
					pq.add(new CostInfo(next, cost[next]));
				}
			}
		}

		return cost[end];
	}

	public static class CostInfo {
		int idx, cost;

		public CostInfo(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}