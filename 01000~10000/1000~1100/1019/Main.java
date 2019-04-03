import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 10; i++) {
			bw.write(solve(n, i) + " ");
		}
		bw.flush();
	}

	public static long solve(long n, long p) {
		long result = 0;

		if (p != 0) {
			for (int i = 1; i <= 10; i++) {
				long div = (long) Math.pow(10, i);
				result += n / div * (div / 10);
				if ((n / (div / 10)) % 10 > p) {
					result += div / 10;
				} else if ((n / (div / 10)) % 10 == p) {
					result += (n % (div / 10)) + 1;
				}
			}
		} else {
			for (int i = 1; i <= 10; i++) {
				long div = (long) Math.pow(10, i);
				if (n >= div) {
					result += (n / div - 1) * div / 10;
					if ((n * 10 / div) % 10 == 0) {
						result += (n % (div / 10)) + 1;
					} else {
						result += div / 10;
					}
				}
			}
		}

		return result;
	}
}