package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p);

		int now = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			now += p[i];
			sum += now;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sum + "");
		bw.flush();
	}
}