import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return Integer.compare(o1, o2);
				} else {
					return Integer.compare(Math.abs(o1), Math.abs(o2));
				}
			}
		});

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write(pq.poll() + "\n");
				}
			} else {
				pq.add(x);
			}
		}

		bw.flush();
	}
}