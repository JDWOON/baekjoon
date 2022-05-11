import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		TreeSet<Sequence> ts = new TreeSet<Sequence>(new Comparator<Sequence>() {
			@Override
			public int compare(Sequence o1, Sequence o2) {
				for (int i = 0; i < o1.val.length; i++) {
					if (o1.val[i] != o2.val[i]) {
						return Integer.compare(o1.val[i], o2.val[i]);
					}
				}
				return 0;
			}
		});

		solve(a, n, m, new LinkedList<Integer>(), new boolean[n], ts);

		for (Sequence s : ts) {
			bw.write(s.getStr() + "\n");
		}
		bw.flush();
	}

	public static void solve(int[] a, int n, int m, LinkedList<Integer> list, boolean[] isVisit, TreeSet<Sequence> ts)
			throws IOException {
		if (list.size() == m) {
			ts.add(new Sequence(a, list));
		} else {
			for (int i = 0; i < n; i++) {
				if (!isVisit[i]) {
					isVisit[i] = true;
					list.add(i);
					solve(a, n, m, list, isVisit, ts);
					list.removeLast();
					isVisit[i] = false;
				}
			}
		}
	}

	public static class Sequence {
		int[] val;

		public Sequence(int[] a, LinkedList<Integer> list) {
			val = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				val[i] = a[list.get(i)];
			}
		}

		public String getStr() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < val.length; i++) {
				sb.append(val[i] + " ");
			}
			return sb.toString();
		}
	}
}