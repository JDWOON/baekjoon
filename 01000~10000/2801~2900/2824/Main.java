import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> la = new ArrayList<Integer>();
		ArrayList<Integer> lb = new ArrayList<Integer>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			la.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			lb.add(Integer.parseInt(st.nextToken()));
		}

		bw.write(solve(la, lb) + "\n");
		bw.flush();
	}

	public static String solve(ArrayList<Integer> la, ArrayList<Integer> lb) {
		TreeMap<Integer, Integer> ma = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> mb = new TreeMap<Integer, Integer>();

		for (int i = 0; i < la.size(); i++) {
			int now = la.get(i);

			for (int j = 2; j < Math.sqrt(now) + 1; j++) {
				while (now % j == 0) {
					now /= j;
					addEntry(ma, j);
				}
			}

			addEntry(ma, now);
		}

		for (int i = 0; i < lb.size(); i++) {
			int now = lb.get(i);

			for (int j = 2; j < Math.sqrt(now) + 1; j++) {
				while (now % j == 0) {
					now /= j;
					addEntry(mb, j);
				}
			}

			addEntry(mb, now);
		}

		Long result = 1l;
		boolean isOver = false;

		while (!ma.isEmpty() && !mb.isEmpty()) {
			int ka = ma.firstKey();
			int kb = mb.firstKey();

			if (ka == kb) {
				int pow = Math.min(ma.get(ka), mb.get(kb));

				for (int i = 0; i < pow; i++) {
					result = result * ka;
					if (result > 1000000000) {
						isOver = true;
					}
					result %= 1000000000;
				}

				ma.remove(ka);
				mb.remove(kb);
			} else if (ka < kb) {
				ma.remove(ka);
			} else {
				mb.remove(kb);
			}
		}

		String str = result.toString();

		if (isOver) {
			while (str.length() < 9) {
				str = "0" + str;
			}
		}

		return str;
	}

	public static void addEntry(TreeMap<Integer, Integer> tm, int key) {
		if (tm.containsKey(key)) {
			tm.put(key, tm.get(key) + 1);
		} else {
			tm.put(key, 1);
		}
	}
}
