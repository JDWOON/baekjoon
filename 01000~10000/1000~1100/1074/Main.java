package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = 1 << Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int result = 0;

		while (n > 1) {
			if (r >= n / 2) {
				result += n * n / 2;
				r -= n / 2;

			}
			if (c >= n / 2) {
				result += n * n / 4;
				c -= n / 2;
			}
			n /= 2;
		}

		System.out.println(result);
	}
}