import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int MAX = 10000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			String[] list = new String[MAX];

			bw.write(bfs(list, a, b) + "\n");

		}

		bw.flush();
	}

	public static String bfs(String[] list, int start, int end) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		list[start] = "";

		while (queue.size() > 0) {
			int prev = queue.pollFirst();

			char[] cmds = new char[] { 'D', 'S', 'L', 'R' };
			int[] nexts = new int[] { (prev * 2) % MAX, (prev + 9999) % MAX, ((prev * 10) + (prev / 1000)) % MAX,
					((prev % 10) * 1000 + (prev / 10)) % MAX };

			for (int i = 0; i < 4; i++) {
				if (list[nexts[i]] == null || list[nexts[i]].length() > list[prev].length() + 1) {
					queue.add(nexts[i]);
					list[nexts[i]] = list[prev] + cmds[i];
				}

				if (nexts[i] == end) {
					return list[end];
				}
			}
		}

		return list[end];
	}
}