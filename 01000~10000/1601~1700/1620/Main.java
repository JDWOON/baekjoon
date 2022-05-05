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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] arr = new String[n + 1];

		for (int i = 1; i < n + 1; i++) {
			String s = br.readLine();
			map.put(s, i);
			arr[i] = s;
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			if (map.containsKey(s)) {
				bw.write(map.get(s) + "\n");
			} else {
				bw.write(arr[Integer.parseInt(s)] + "\n");
			}
		}

		bw.flush();
	}
}