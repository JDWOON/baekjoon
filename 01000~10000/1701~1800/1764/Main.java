import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			hs.add(br.readLine());
		}

		TreeSet<String> ts = new TreeSet<String>();

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			if (hs.contains(s)) {
				ts.add(s);
			}
		}

		bw.write(ts.size() + "\n");
		for (String s : ts) {
			bw.write(s + "\n");
		}

		bw.flush();
	}
}