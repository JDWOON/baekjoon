package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] maxS = { 0, 0, 0 };
		int[] minS = { 0, 0, 0 };

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");

			int[] maxT = { maxS[0], maxS[1], maxS[2] };
			int[] minT = { minS[0], minS[1], minS[2] };

			maxS[0] = Math.max(maxT[0], maxT[1]) + Integer.parseInt(s[0]);
			maxS[1] = Math.max(Math.max(maxT[0], maxT[1]), maxT[2]) + Integer.parseInt(s[1]);
			maxS[2] = Math.max(maxT[1], maxT[2]) + Integer.parseInt(s[2]);

			minS[0] = Math.min(minT[0], minT[1]) + Integer.parseInt(s[0]);
			minS[1] = Math.min(Math.min(minT[0], minT[1]), minT[2]) + Integer.parseInt(s[1]);
			minS[2] = Math.min(minT[1], minT[2]) + Integer.parseInt(s[2]);
		}

		int maxVal = Math.max(Math.max(maxS[0], maxS[1]), maxS[2]);
		int minVal = Math.min(Math.min(minS[0], minS[1]), minS[2]); 
		bw.write(maxVal + " " + minVal);
		bw.flush();
	}
}