import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long[] f = new long[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			f[i] = Long.parseLong(st.nextToken());
		}

		long k = Long.parseLong(br.readLine());

		boolean isMeet = f[1] == k;

		for (int i = 1; i < n; i++) {
			long a = Long.compare(k * i, f[i]);
			long b = Long.compare(k * (i + 1), f[i + 1]);

			if (a * b <= 0) {
				isMeet = true;
				break;
			}
		}

		bw.write(isMeet ? "T" : "F");

		bw.flush();
	}
}