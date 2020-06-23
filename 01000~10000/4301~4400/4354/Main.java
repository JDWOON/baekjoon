import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String s = br.readLine();

		while (s.charAt(0) != '.') {
			bw.write(solve(s) + "\n");
			s = br.readLine();
		}

		bw.flush();

	}

	public static int solve(String s) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < s.length(); i++) {
			if (s.length() % i == 0) {
				list.add(i);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int nowLen = list.get(i);
			boolean check = true;
			for (int j = 0; check && j < s.length() / nowLen; j++) {
				for (int k = 0; check && k < nowLen; k++) {
					if (s.charAt(k) != s.charAt(j * nowLen + k)) {
						check = false;
						break;
					}
				}
			}

			if (check) {
				return s.length() / nowLen;
			}
		}

		return 1;
	}
}
