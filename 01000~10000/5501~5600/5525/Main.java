import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int cnt = 0, result = 0;
		for (int i = 0; i < m; i++) {
			if ((cnt % 2 == 0 && s.charAt(i) == 'I') || (cnt % 2 == 1 && s.charAt(i) == 'O')) {
				cnt++;
			} else if (s.charAt(i) == 'I') {
				cnt = 1;
			} else {
				cnt = 0;
			}

			if (cnt > n * 2 && cnt % 2 == 1) {
				result++;
			}
		}

		bw.write(result + "\n");

		bw.flush();
	}
}