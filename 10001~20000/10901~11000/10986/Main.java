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
		int m = Integer.parseInt(st.nextToken());

		long[] sum = new long[m];
		Arrays.fill(sum, 0);

		st = new StringTokenizer(br.readLine(), " ");

		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp = (temp + Integer.parseInt(st.nextToken())) % m;
			sum[temp]++;
		}

		long result = sum[0];

		for (int i = 0; i < m; i++) {
			if (sum[i] > 1) {
				result += (sum[i] * (sum[i] - 1)) / 2;
			}
		}

		System.out.println(result);
	}
}