import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] list = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> left = new Stack<Integer>();

		for (int i = 1; i < n + 1; i++) {
			int prev = 0;

			while (!left.isEmpty() && list[prev] <= list[i]) {
				prev = left.pop();
			}

			if (list[prev] < list[i]) {
				bw.write("0 ");
			} else {
				bw.write(prev + " ");
				left.push(prev);
			}

			left.push(i);
		}

		bw.flush();
	}
}
