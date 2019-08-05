import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		while (n > 1) {
			int temp = solve(n);
			n /= temp;
			bw.write(temp + "\n");
		}

		bw.flush();
	}

	public static int solve(int n) {
		for (int i = 2; i <= Math.sqrt((double) n) + 1; i++) {
			if (n % i == 0) {
				return i;
			}
		}

		return n;
	}
}
