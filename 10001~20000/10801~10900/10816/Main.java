import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());

			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int val = Integer.parseInt(st.nextToken());

			bw.write((map.containsKey(val) ? map.get(val) : 0) + " ");
		}

		bw.flush();
	}
}