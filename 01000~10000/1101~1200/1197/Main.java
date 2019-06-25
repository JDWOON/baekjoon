import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.sound.midi.Instrument;

public class Main {
	static int v, e;
	static boolean[] isDone;
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static ArrayList<Dot>[] lists;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		lists = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			lists[i] = new ArrayList<Dot>();
		}

		int idx = 0;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (map.containsKey(a)) {
				a = map.get(a);
			} else {
				map.put(a, idx);
				a = idx;
				idx++;
			}

			if (map.containsKey(b)) {
				b = map.get(b);
			} else {
				map.put(b, idx);
				b = idx;
				idx++;
			}

			lists[a].add(new Dot(b, c));
			lists[b].add(new Dot(a, c));
		}

		isDone = new boolean[v];
		Arrays.fill(isDone, false);

		bw.write(solve() + "\n");
		bw.flush();
	}

	public static long solve() {
		long sum = 0;
		int cnt = 1;

		boolean[] dests = new boolean[v];
		Arrays.fill(dests, false);
		int[] vals = new int[v];
		Arrays.fill(vals, Integer.MAX_VALUE);

		isDone[0] = true;
		for (Dot dot : lists[0]) {
			dests[dot.dest] = true;
			vals[dot.dest] = dot.weight;
		}

		while (cnt < v) {
			int next = -1;
			int nextVal = Integer.MAX_VALUE;

			for (int i = 0; i < v; i++) {
				if (dests[i] && !isDone[i] && vals[i] < nextVal) {
					next = i;
					nextVal = vals[i];
				}
			}

			cnt++;
			sum += nextVal;
			isDone[next] = true;

			for (Dot dot : lists[next]) {
				dests[dot.dest] = true;
				vals[dot.dest] = Math.min(vals[dot.dest], dot.weight);
			}
		}

		return sum;
	}

	public static class Dot {
		public int dest, weight;

		Dot(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}