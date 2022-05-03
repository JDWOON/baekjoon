import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			} else {
				bw.write(isPal(n) ? "yes\n" : "no\n");
			}
		}

		bw.flush();
	}

	public static boolean isPal(int n) {
		int temp = 0;

		for (int i = n; i > 0; i /= 10) {
			temp = temp * 10 + (i % 10);
		}

		return n == temp;
	}
}