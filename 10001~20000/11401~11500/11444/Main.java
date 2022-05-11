import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static long MOD = 1000000007l;
	public static long P = 2000000016l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		long n = Long.parseLong(br.readLine());

		bw.write(solve(n) + "\n");

		bw.flush();
	}

	public static long solve(long n) {
		n %= P;

		long[][] result = new long[][] { { 1, 0 }, { 0, 1 } };

		while (n > 0) {
			long[][] temp = new long[][] { { 1, 1 }, { 1, 0 } };
			long idx = 1;

			while (idx * 2 <= n) {
				temp = matMul(temp, temp);
				idx *= 2;
			}

			result = matMul(result, temp);
			n -= idx;
		}

		return result[0][1];
	}

	public static long[][] matMul(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
				result[i][j] %= MOD;
			}
		}

		return result;
	}
}