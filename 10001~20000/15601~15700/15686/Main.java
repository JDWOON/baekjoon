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

	public static long MOD = 1000000007l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Dot> homes = new LinkedList<Dot>();
		LinkedList<Dot> chicks = new LinkedList<Dot>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp == 1) {
					homes.add(new Dot(i, j));
				} else if (temp == 2) {
					chicks.add(new Dot(i, j));
				}
			}
		}

		int[][] vals = new int[homes.size()][chicks.size()];

		for (int i = 0; i < homes.size(); i++) {
			for (int j = 0; j < chicks.size(); j++) {
				vals[i][j] = Math.abs(homes.get(i).r - chicks.get(j).r) + Math.abs(homes.get(i).c - chicks.get(j).c);
			}
		}

		bw.write(solve(vals, new LinkedList<Integer>(), m, 0) + "\n");

		bw.flush();
	}

	public static int solve(int[][] vals, LinkedList<Integer> list, int m, int now) {
		if (list.size() == m) {
			int result = 0;
			for (int i = 0; i < vals.length; i++) {
				int val = Integer.MAX_VALUE;
				for (int chick : list) {
					val = Math.min(val, vals[i][chick]);
				}
				result += val;
			}
			return result;
		} else if (now < vals[0].length) {
			int result = Integer.MAX_VALUE;

			list.addLast(now);
			result = Math.min(result, solve(vals, list, m, now + 1));
			list.removeLast();
			result = Math.min(result, solve(vals, list, m, now + 1));

			return result;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}