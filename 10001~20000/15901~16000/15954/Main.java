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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		double[] a = new double[n];
		double[] sum = new double[n + 1];
		sum[0] = 0;

		for (int i = 0; i < n; i++) {
			a[i] = Double.parseDouble(st.nextToken());
			sum[i + 1] = sum[i] + a[i];
		}

		double min = Double.MAX_VALUE;

		for (int i = 0; i < n - k + 1; i++) {
			for (int j = k; i + j < n + 1; j++) {
				double avr = (sum[i + j] - sum[i]) / j;

				double temp = 0;

				for (int x = 0; x < j; x++) {
					temp += (a[i + x] - avr) * (a[i + x] - avr);
				}

				temp /= j;

				if (temp < min) {
					min = temp;
				}
			}
		}

		min = Math.sqrt(min);

		bw.write(min + "\n");

		bw.flush();
	}
}