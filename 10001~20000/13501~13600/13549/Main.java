import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int MAX = 100001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bw.write(solve(n, k) + "\n");

		bw.flush();
	}

	public static int solve(int n, int k) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] val = new int[MAX];
		val[n] = 1;

		queue.add(n);

		while (queue.size() > 0) {
			int now = queue.poll();

			if (now == k) {
				return val[now] - 1;
			}

			if (now > 0) {
				for (int i = now; i < MAX; i *= 2) {
					if (val[i] == 0) {
						queue.add(i);
						val[i] = val[now];
					}
				}
			}

			if (now > 0 && val[now - 1] == 0) {
				queue.add(now - 1);
				val[now - 1] = val[now] + 1;
			}
			if (now < MAX - 1 && val[now + 1] == 0) {
				queue.add(now + 1);
				val[now + 1] = val[now] + 1;
			}
		}

		return -1;
	}
}