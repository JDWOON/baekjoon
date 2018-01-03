package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		Integer[] sort = new Integer[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			sort[i] = i;
		}

		Arrays.sort(sort, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(x[o1], x[o2]);
			}
		});

		int min = 800000001;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n && (x[sort[j]] - x[sort[i]]) * (x[sort[j]] - x[sort[i]]) < min; j++) {
				if ((y[sort[j]] - y[sort[i]]) * (y[sort[j]] - y[sort[i]]) < min) {
					int temp = (x[sort[j]] - x[sort[i]]) * (x[sort[j]] - x[sort[i]])
							+ (y[sort[j]] - y[sort[i]]) * (y[sort[j]] - y[sort[i]]);
					min = Math.min(min, temp);
				}
			}
		}

		System.out.println(min);
	}
}