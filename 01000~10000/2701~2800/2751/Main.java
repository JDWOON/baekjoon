package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(p);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < p.length; i++) {
			bw.write(p[i] + "\n");
		}

		bw.flush();
	}
}