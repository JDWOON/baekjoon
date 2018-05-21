package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] x = new int[n];
		int[] y = new int[n];
		Integer[] idx = new Integer[n];

		int xMin = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			idx[i] = i;
			if (x[i] < x[xMin]) {
				xMin = i;
			} else if (x[i] == x[xMin] && y[i] > y[xMin]) {
				xMin = i;
			}
		}

		slopeSort(x, y, idx, xMin);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solve(x, y, idx) + "\n");
		bw.flush();
	}

	public static int solve(int[] x, int[] y, Integer[] idx) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		for (int i = 2; i < idx.length + 1; i++) {
			long ax, ay, bx, by;
			int prev, now, next = 0;

			while (list.size() > 1) {
				now = list.get(list.size() - 1);
				prev = list.get(list.size() - 2);
				next = i % idx.length;

				ax = (x[idx[now]] - x[idx[prev]]);
				ay = (y[idx[now]] - y[idx[prev]]);
				bx = (x[idx[next]] - x[idx[now]]);
				by = (y[idx[next]] - y[idx[now]]);

				if (ax * by - ay * bx <= 0) {
					list.remove(list.size() - 1);
				} else {
					break;
				}
			}

			if (next > 0) {
				list.add(next);
			}
		}

		return list.size();
	}

	public static void slopeSort(int[] x, int[] y, Integer[] idx, int xMin) {
		Arrays.sort(idx, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (xMin == o1) {
					return -1;
				} else if (xMin == o2) {
					return 1;
				} else {
					long ax = x[o1] - x[xMin];
					long ay = y[o1] - y[xMin];
					long bx = x[o2] - x[xMin];
					long by = y[o2] - y[xMin];

					if (ay * bx - ax * by == 0) {
						return Long.compare(Math.abs(ax), Math.abs(ay));
					} else {
						return (ay * bx - ax * by) < 0 ? -1 : 1;
					}
				}
			}
		});
	}
}