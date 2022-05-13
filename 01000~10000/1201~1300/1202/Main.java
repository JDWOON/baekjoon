import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Gem> gems = new PriorityQueue<Gem>(new Comparator<Gem>() {
			@Override
			public int compare(Gem o1, Gem o2) {
				return Long.compare(o1.m, o2.m);
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long m = Long.parseLong(st.nextToken());
			long v = Long.parseLong(st.nextToken());

			gems.add(new Gem(m, v));
		}

		long[] bags = new long[k];

		for (int i = 0; i < k; i++) {
			bags[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(bags);

		PriorityQueue<Gem> availGems = new PriorityQueue<Gem>(new Comparator<Gem>() {
			@Override
			public int compare(Gem o1, Gem o2) {
				return Long.compare(o2.v, o1.v);
			}
		});

		long result = 0;

		for (int i = 0; i < k; i++) {
			while (!gems.isEmpty() && gems.peek().m <= bags[i]) {
				availGems.add(gems.poll());
			}

			if (!availGems.isEmpty()) {
				result += availGems.poll().v;
			}
		}

		bw.write(result + "\n");

		bw.flush();
	}

	public static class Gem {
		long m, v;

		public Gem(long m, long v) {
			this.m = m;
			this.v = v;
		}
	}
}