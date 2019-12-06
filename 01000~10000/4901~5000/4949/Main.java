import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String input = br.readLine();

		while (input.length() > 1 && input.charAt(0) != '.') {
			String s = new String();

			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == ')' || input.charAt(i) == '['
						|| input.charAt(i) == ']') {
					s = s + input.charAt(i);

				}
			}

			String result = isBalanced(s) ? "yes" : "no";

			bw.write(result + "\n");

			input = br.readLine();
		}

		bw.flush();
	}

	public static boolean isBalanced(String s) {
		if (s.length() == 0) {
			return true;
		} else if (s.charAt(0) == '(' || s.charAt(0) == '[') {
			char left = s.charAt(0);
			char right = left == '(' ? ')' : ']';
			int cnt = 1;

			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == left) {
					cnt++;
				} else if (s.charAt(i) == right) {
					cnt--;
				}

				if (cnt == 0) {
					return isBalanced(s.substring(1, i)) & isBalanced(s.substring(i + 1));
				}
			}
		}

		return false;
	}
}