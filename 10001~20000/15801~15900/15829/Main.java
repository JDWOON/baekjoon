import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());
		String s = br.readLine();

		bw.write(hash(s) + "\n");

		bw.flush();

	}

	public static long hash(String s) {
		long result = 0;
		long r = 1;
		long mod = 1234567891;

		for (int i = 0; i < s.length(); i++) {
			long temp = s.charAt(i) - 'a' + 1;
			result += temp * r;
			result %= mod;

			r = (r * 31) % mod;
		}

		return result;
	}
}