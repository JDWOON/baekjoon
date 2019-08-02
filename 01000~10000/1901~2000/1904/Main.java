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
		int now = 1, prev = 0;

		for (int i = 0; i < n; i++) {
			int temp = now;
			now = (now + prev) % 15746;
			prev = temp;
		}

		return now;
	}
}
