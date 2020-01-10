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
		int n = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());

			if (next == 0) {
				if (tm.isEmpty()) {
					bw.write("0\n");
				} else {
					int first = tm.firstKey();
					bw.write(first + "\n");

					if (tm.get(first) > 1) {
						tm.put(first, tm.get(first) - 1);
					} else {
						tm.remove(first);
					}
				}
			} else {
				if (tm.containsKey(next)) {
					tm.put(next, tm.get(next) + 1);
				} else {
					tm.put(next, 1);
				}
			}
		}

		bw.flush();

	}
}
