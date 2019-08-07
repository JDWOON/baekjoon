import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		bw.write(solve(n) + "\n");
		bw.flush();
	}

	public static int solve(int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < n + 1; i++) {
			list.add(i);
		}

		while (list.size() > 1) {
			list.removeFirst();
			int temp = list.removeFirst();
			list.add(temp);
		}

		return list.removeFirst();
	}
}
