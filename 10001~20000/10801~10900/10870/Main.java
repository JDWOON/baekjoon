import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		bw.write(solve(n) + "\n");
		bw.flush();
	}

	public static int solve(int n) {
		int[] p = new int[21];
		p[0] = 0;
		p[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			p[i] = p[i - 1] + p[i - 2];
		}

		return p[n];
	}
}