import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[20];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();

			if ("all".equals(cmd)) {
				Arrays.fill(arr, true);
			} else if ("empty".equals(cmd)) {
				Arrays.fill(arr, false);
			} else {
				int val = Integer.parseInt(st.nextToken()) - 1;

				if ("add".equals(cmd)) {
					arr[val] = true;
				} else if ("remove".equals(cmd)) {
					arr[val] = false;
				} else if ("toggle".equals(cmd)) {
					arr[val] = !arr[val];
				} else if ("check".equals(cmd)) {
					bw.write(arr[val] ? "1\n" : "0\n");
				}
			}
		}

		bw.flush();
	}
}