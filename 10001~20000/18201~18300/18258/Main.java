import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;

			switch (st.nextToken()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				continue;
			case "pop":
				result = q.isEmpty() ? -1 : q.pollFirst();
				break;
			case "size":
				result = q.size();
				break;
			case "empty":
				result = q.isEmpty() ? 1 : 0;
				break;
			case "front":
				result = q.isEmpty() ? -1 : q.getFirst();
				break;
			case "back":
				result = q.isEmpty() ? -1 : q.getLast();
				break;
			}

			bw.write(result + "\n");
		}

		bw.flush();
	}
}
