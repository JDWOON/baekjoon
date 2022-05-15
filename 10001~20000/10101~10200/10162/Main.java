import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] t = { 300, 60, 10 };

		int n = Integer.parseInt(br.readLine());

		int[] result = new int[t.length];

		for (int i = 0; i < t.length; i++) {
			result[i] = n / t[i];
			n %= t[i];
		}

		if (n == 0) {
			for (int val : result) {
				bw.write(val + " ");
			}
		} else {
			bw.write("-1");
		}

		bw.flush();
	}
}