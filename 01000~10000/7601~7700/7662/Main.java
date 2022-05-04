import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
			int k = Integer.parseInt(br.readLine());

			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int val = Integer.parseInt(st.nextToken());

				if (s.equals("I")) {
					tm.put(val, tm.containsKey(val) ? tm.get(val) + 1 : 1);
				} else if (s.equals("D") && !tm.isEmpty()) {
					int key = val == -1 ? tm.firstKey() : tm.lastKey();
					if (tm.get(key) == 1) {
						tm.remove(key);
					} else {
						tm.put(key, tm.get(key) - 1);
					}
				}
			}

			if (tm.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(tm.lastKey() + " " + tm.firstKey() + "\n");
			}
		}

		bw.flush();
	}
}
