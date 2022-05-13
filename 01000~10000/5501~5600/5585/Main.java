import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] c = new int[] { 500, 100, 50, 10, 5, 1 };

		int n = 1000 - Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 0; i < c.length; i++) {
			result += n / c[i];
			n %= c[i];
		}

		bw.write(result + "\n");

		bw.flush();
	}
}