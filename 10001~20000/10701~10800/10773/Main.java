import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < k; i++) {
			int a = Integer.parseInt(br.readLine());

			if (a == 0) {
				st.pop();
			} else {
				st.push(a);
			}
		}

		int sum = 0;

		while (st.size() > 0) {
			sum += st.pop();
		}

		bw.write(sum + "");

		bw.flush();
	}
}