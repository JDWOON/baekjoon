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

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());

		bw.write(solve(a, b) + "\n");

		bw.flush();
	}

	public static int solve(long a, long b) {
		LinkedList<Long> list = new LinkedList<Long>();
		list.add(a);

		int cnt = 1;
		while (cnt < 1000) {
			LinkedList<Long> nexts = new LinkedList<Long>();

			for (long val : list) {
				if (val == b) {
					return cnt;
				}
				if (val * 2 <= b) {
					nexts.add(val * 2);
				}
				if (val * 10 + 1 <= b) {
					nexts.add(val * 10 + 1);
				}
			}

			list.clear();
			list.addAll(nexts);
			cnt++;
		}

		return -1;
	}
}