package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] p = new int[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				p[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (p[j] > 0) {
					int k = j;
					while (p[k] > 0) {
						int temp = p[k];
						p[k] = 0;
						k = temp;
					}
					cnt++;
				}
			}

			System.out.println(cnt);
		}
	}
}