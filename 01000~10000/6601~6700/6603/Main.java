import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			} else {
				int[] list = new int[n];

				for (int i = 0; i < n; i++) {
					list[i] = Integer.parseInt(st.nextToken());
				}

				bw.write(solve(list) + "\n");
			}
		}

		bw.flush();
	}

	public static String solve(int[] list) {
		boolean[] check = new boolean[list.length];
		Arrays.fill(check, false);

		return visit(list, check, 0, 0).toString();
	}

	public static StringBuilder visit(int[] list, boolean[] check, int now, int cnt) {
		StringBuilder result = new StringBuilder();
		if (cnt == 6) {
			for (int i = 0; i < list.length; i++) {
				if (check[i]) {
					result.append(list[i] + " ");
				}
			}

			return result.append("\n");
		} else if (6 - cnt > list.length - now) {
			return result;
		} else {
			for (int i = now; i < list.length; i++) {
				if (!check[i]) {
					check[i] = true;
					result.append(visit(list, check, i, cnt + 1));
					check[i] = false;
				}
			}

			return result;
		}
	}
}
