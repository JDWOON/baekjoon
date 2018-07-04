package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());

		int[] val = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}

		new Main().solve(val);
	}

	public void solve(int[] val) {
		Arrays.sort(val);

		int a = 0, b = 0;
		int left = 0, right = val.length - 1, min = Integer.MAX_VALUE;

		while (left < right) {
			int sum = val[left] + val[right];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				a = left;
				b = right;
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(val[a] + " " + val[b]);
	}
}