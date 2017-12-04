package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[10001];
		Arrays.fill(cnt, 0);

		for (int i = 0; i < n; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 10001; i++) {
			while (cnt[i] > 0) {
				bw.write(i + "\n");
				cnt[i]--;
			}
		}

		bw.flush();
	}
}