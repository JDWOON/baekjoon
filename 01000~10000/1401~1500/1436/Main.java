import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
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
		for (int i = 0; i < 10000000; i++) {
			if (check(i)) {
				n--;
			}

			if (n == 0) {
				return i;
			}
		}

		return -1;
	}

	public static boolean check(int k) {
		String s = Integer.toString(k);
		return s.contains("666");
	}
}
