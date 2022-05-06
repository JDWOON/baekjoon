import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] sort = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
			sort[i] = x[i];
		}

		Arrays.sort(sort);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(sort[i])) {
				map.put(sort[i], idx);
				idx++;
			}
		}

		for (int xi : x) {
			bw.write(map.get(xi) + " ");
		}

		bw.flush();
	}
}