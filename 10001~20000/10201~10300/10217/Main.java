package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			t--;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			ArrayList<AirInfo>[] list = new ArrayList[n + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<AirInfo>();
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int now = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list[now].add(new AirInfo(next, cost, time));
			}

			int[][] dp = new int[n + 1][m + 1];

			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					dp[i][j] = -1;
				}
			}

			new Main().solve(list, dp, m);

			int result = Integer.MAX_VALUE;
			for (int i = 0; i < m + 1; i++) {
				if (dp[n][i] != -1) {
					result = Math.min(result, dp[n][i]);
				}
			}

			if (result == Integer.MAX_VALUE) {
				System.out.println("Poor KCM");
			} else {
				System.out.println(result);
			}
		}
	}

	public void solve(ArrayList<AirInfo>[] list, int[][] dp, int m) {
		Arrays.fill(dp[0], 0);

		PriorityQueue<AirInfo> pq = new PriorityQueue<>(list.length, new Comparator<AirInfo>() {
			@Override
			public int compare(AirInfo o1, AirInfo o2) {
				return Integer.compare(o1.time, o2.time);
			}
		});

		pq.add(new AirInfo(1, 0, 0));

		while (!pq.isEmpty()) {
			AirInfo now = pq.poll();
			for (int i = 0; i < list[now.id].size(); i++) {
				AirInfo next = list[now.id].get(i);
				int totalCost = now.cost + next.cost;
				int totalTime = now.time + next.time;
				if (totalCost <= m && (dp[next.id][totalCost] == -1 || dp[next.id][totalCost] > totalTime)
						&& totalCost <= m) {
					for (int j = totalCost; j < dp[0].length; j++) {
						if (dp[next.id][j] != -1 && dp[next.id][j] <= totalTime) {
							break;
						} else {
							dp[next.id][j] = totalTime;
						}
					}
					pq.add(new AirInfo(next.id, totalCost, totalTime));
				}
			}
		}
	}
}

class AirInfo {
	int id;
	int cost;
	int time;

	public AirInfo(int id, int cost, int time) {
		this.id = id;
		this.cost = cost;
		this.time = time;
	}
}