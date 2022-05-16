import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static long MOD = 1000000007l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int m = Integer.parseInt(br.readLine());

		long[] n = new long[m];
		long[] s = new long[m];

		long result = 0;

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n[i] = Long.parseLong(st.nextToken());
			s[i] = Long.parseLong(st.nextToken());

			result = (result + (modPow(n[i], MOD - 2, MOD) * s[i])) % MOD;

		}

		bw.write(result + "\n");

		bw.flush();
	}

	public static long modPow(long a, long b, long mod) {
		long result = 1;

		while (b > 0) {
			long x = a, y = 1;

			while (y * 2 <= b) {
				x = (x * x) % mod;
				y *= 2;
			}

			result = (result * x) % mod;
			b -= y;
		}

		return result;
	}
}