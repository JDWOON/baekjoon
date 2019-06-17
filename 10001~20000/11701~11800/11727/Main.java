import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n + 1];
		p[0] = 1;
		p[1] = 1;

		bw.write(solve(p, n) + "\n");
		bw.flush();
	}

	public static int solve(int[] p, int n) {
		if (p[n] > 0) {
			return p[n];
		} else {
			p[n] = (solve(p, n - 1) + solve(p, n - 2) * 2) % 10007;
			return p[n];
		}
	}
}