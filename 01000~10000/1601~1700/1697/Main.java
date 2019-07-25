import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bw.write(solve(n, k) + "\n");
		bw.flush();
	}

	public static int solve(int n, int k) {
		int[] list = new int[100001];
		Arrays.fill(list, -1);
		list[n] = 0;

		Stack<Dot> st = new Stack<Dot>();
		st.push(new Dot(n, 0));

		while (!st.empty()) {
			Stack<Dot> temp = new Stack<Dot>();

			while (!st.empty()) {
				Dot now = st.pop();
				int x = now.x;
				int cnt = now.cnt;

				if (x < 100000 && (list[x + 1] == -1)) {
					list[x + 1] = cnt + 1;
					temp.push(new Dot(x + 1, cnt + 1));
				}

				if (x > 0 && (list[x - 1] == -1)) {
					list[x - 1] = cnt + 1;
					temp.push(new Dot(x - 1, cnt + 1));
				}

				if (x < 50001 && (list[x * 2] == -1)) {
					list[x * 2] = cnt + 1;
					temp.push(new Dot(x * 2, cnt + 1));
				}
			}

			st.addAll(temp);
		}

		return list[k];
	}

	public static class Dot {
		int x, cnt;

		Dot(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
}
