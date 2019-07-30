import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] list = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(list, s) + "\n");
		bw.flush();
	}

	public static int solve(int[] list, int s) {
		int len = Integer.MAX_VALUE, start = 0, end = 0;

		while (start < list.length) {
			while (end < list.length && s > 0) {
				s -= list[end];
				end++;
			}

			if (s > 0) {
				break;
			} else {
				len = Math.min(len, end - start);
			}

			s += list[start];
			start++;
		}

		return len == Integer.MAX_VALUE ? 0 : len;
	}
}
