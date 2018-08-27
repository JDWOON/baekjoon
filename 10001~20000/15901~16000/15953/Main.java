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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int sum = 0;

			if (a > 0) {
				if (a <= 1) {
					sum += 500;
				} else if (a <= 1 + 2) {
					sum += 300;
				} else if (a <= 1 + 2 + 3) {
					sum += 200;
				} else if (a <= 1 + 2 + 3 + 4) {
					sum += 50;
				} else if (a <= 1 + 2 + 3 + 4 + 5) {
					sum += 30;
				} else if (a <= 1 + 2 + 3 + 4 + 5 + 6) {
					sum += 10;
				}
			}

			if (b > 0) {
				if (b <= 1) {
					sum += 512;
				} else if (b <= 1 + 2) {
					sum += 256;
				} else if (b <= 1 + 2 + 4) {
					sum += 128;
				} else if (b <= 1 + 2 + 4 + 8) {
					sum += 64;
				} else if (b <= 1 + 2 + 4 + 8 + 16) {
					sum += 32;
				}
			}

			sum *= 10000;

			bw.write(sum + "\n");
		}

		bw.flush();
	}
}