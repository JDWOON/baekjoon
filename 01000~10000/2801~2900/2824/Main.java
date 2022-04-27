import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap<Integer, Integer> divA = new TreeMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			addDiv(divA, val);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		TreeMap<Integer, Integer> divB = new TreeMap<Integer, Integer>();

		for (int i = 0; i < m; i++) {
			int val = Integer.parseInt(st.nextToken());
			addDiv(divB, val);
		}

		long result = 1;
		boolean isBig = false;

		while (!divA.isEmpty() && !divB.isEmpty()) {
			int aKey = divA.firstKey();
			int bKey = divB.firstKey();

			if (aKey == bKey) {
				int cnt = Math.min(divA.get(aKey), divB.get(bKey));
				while (cnt > 0) {
					result *= aKey;
					if (result >= 1000000000) {
						isBig = true;
						result %= 1000000000;
					}
					cnt--;
				}

				divA.remove(aKey);
				divB.remove(bKey);
			} else if (aKey < bKey) {
				divA.remove(aKey);
			} else {
				divB.remove(bKey);
			}
		}

		if (isBig) {
			bw.write(String.format("%09d", result) + "\n");
		} else {
			bw.write(result + "\n");
		}

		bw.flush();
	}

	public static void addDiv(Map<Integer, Integer> div, int val) {
		for (int i = 2; i * i <= val; i++) {
			int cnt = 0;

			while (val % i == 0) {
				val /= i;
				cnt++;
			}

			if (cnt > 0) {
				addCnt(div, i, cnt);
				addDiv(div, val);
				return;
			}
		}

		addCnt(div, val, 1);
	}

	public static void addCnt(Map<Integer, Integer> div, int val, int cnt) {
		if (div.containsKey(val)) {
			div.put(val, div.get(val) + cnt);
		} else {
			div.put(val, cnt);
		}
	}
}