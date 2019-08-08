import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[] a = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		long result = 0;

		for (int i = 0; i < n; i++) {
			a[i] -= b;
			result += 1;

			if (a[i] > 0) {
				result += (a[i] / c) + (a[i] % c > 0 ? 1 : 0);
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}
}
