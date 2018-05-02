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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());

		s = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(a, Integer.parseInt(s[i])) > -1) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}

		bw.flush();
	}
}