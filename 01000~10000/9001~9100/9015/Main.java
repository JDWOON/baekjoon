import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];

			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());

				if (!map.containsKey(x[j])) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					map.put(x[j], list);
				}

				map.get(x[j]).add(y[j]);
			}

			bw.write(solve(x, y, map) + "\n");

		}

		bw.flush();
	}

	public static int solve(int[] x, int[] y, HashMap<Integer, ArrayList<Integer>> map) {
		int result = 0;

		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				int dx = x[i] - x[j];
				int dy = y[i] - y[j];

				int x3 = x[i] - dy;
				int y3 = y[i] + dx;
				int x4 = x[j] - dy;
				int y4 = y[j] + dx;

				if (map.containsKey(x3) && map.get(x3).contains(y3) && map.containsKey(x4)
						&& map.get(x4).contains(y4)) {
					result = Math.max(result, (dx * dx) + (dy * dy));
				}

				x3 = x[i] + dy;
				y3 = y[i] - dx;
				x4 = x[j] + dy;
				y4 = y[j] - dx;

				if (map.containsKey(x3) && map.get(x3).contains(y3) && map.containsKey(x4)
						&& map.get(x4).contains(y4)) {
					result = Math.max(result, (dx * dx) + (dy * dy));
				}
			}
		}

		return result;
	}
}