import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] p = new long[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken()) + 100000;
			long y = Long.parseLong(st.nextToken()) + 100000;

			p[i] = (y * 200001) + x;
		}

		Arrays.sort(p);

		for (int i = 0; i < n; i++) {
			long x = (p[i] % 200001) - 100000;
			long y = (p[i] / 200001) - 100000;

			bw.write(x + " " + y + "\n");
		}

		bw.flush();
	}
}
