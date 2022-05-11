import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String s = br.readLine();

		Stack<Character> op = new Stack<Character>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);

			if (now == '(') {
				op.add(now);
			} else if (now == ')') {
				while (op.peek() != '(') {
					sb.append(op.pop());
				}
				op.pop();
			} else if (now == '*' || now == '/') {
				while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
					sb.append(op.pop());
				}
				op.add(now);
			} else if (now == '+' || now == '-') {
				while (!op.isEmpty() && op.peek() != '(') {
					sb.append(op.pop());
				}
				op.add(now);
			} else {
				sb.append(now);
			}
		}

		while (!op.isEmpty()) {
			sb.append(op.pop());
		}

		bw.write(sb.toString() + "\n");

		bw.flush();
	}
}