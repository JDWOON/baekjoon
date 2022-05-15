import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());

		int[] r = new int[n];

		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(r);

		int result = 0;

		for (int i = n - 1; i > -1; i--) {
			result = Math.max(result, r[i] * (n - i));
		}

		bw.write(result + "\n");

		bw.flush();
	}
}