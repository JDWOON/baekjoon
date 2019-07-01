import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxVal = 0;
		int maxIdx = 0;

		for (int i = 1; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n > maxVal) {
				maxVal = n;
				maxIdx = i;
			}
		}

		bw.write(maxVal + "\n" + maxIdx);

		bw.flush();
	}
}