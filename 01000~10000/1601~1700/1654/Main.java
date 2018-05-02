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

		String[] s = br.readLine().split(" ");

		int k = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		long[] line = new long[k];

		for (int i = 0; i < k; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		long left = 1, right = Integer.MAX_VALUE;
		long max = 0;

		while (left < right) {
			long mid = (left + right) / 2;
			if (left == right - 1) {
				if (maxMake(line, left) < n) {
					max = left - 1;
				} else if (maxMake(line, right) < n) {
					max = left;
				} else {
					max = right;
				}
				left = right;
			} else {
				if (maxMake(line, mid) < n) {
					right = mid;
				} else {
					left = mid;
				}
			}
		}

		bw.write(max + "");
		bw.flush();
	}

	public static long maxMake(long[] line, long len) {		
		int cnt = 0;

		for (int i = 0; i < line.length; i++) {
			cnt += line[i] / len;
		}

		return cnt;
	}
}
