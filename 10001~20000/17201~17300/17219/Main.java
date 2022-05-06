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

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String site = st.nextToken();
			String pwd = st.nextToken();

			map.put(site, pwd);
		}

		for (int i = 0; i < m; i++) {
			String site = br.readLine();

			bw.write(map.get(site) + "\n");
		}

		bw.flush();
	}
}