import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bw.write(solve(n, k) + "\n");
		bw.flush();

	}

	public static int solve(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 2; i <= n; i++) {
			list.add(i);
		}

		int cnt = 0;

		while (cnt < k) {
			int p = list.get(0);

			if (cnt == k - 1) {
				return p;
			}

			list.remove(0);
			cnt++;

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) % p == 0) {
					if (cnt == k - 1) {
						return list.get(i);
					}

					list.remove(i);
					cnt++;
					i--;
				}

			}
		}

		return -1;
	}
}
