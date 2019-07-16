import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Conference[] list = new Conference[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new Conference(start, end);
		}

		bw.write(solve(list) + "\n");
		bw.flush();
	}

	public static int solve(Conference[] list) {
		Arrays.sort(list, new Comparator<Conference>() {
			@Override
			public int compare(Conference o1, Conference o2) {
				if (o1.start != o2.start) {
					return Integer.compare(o1.start, o2.start);
				} else {
					return Integer.compare(o1.end, o2.end);
				}
			}
		});

		Conference last = list[0];
		int cnt = 1;

		for (int i = 1; i < list.length; i++) {
			if (last.end <= list[i].start) {
				last = list[i];
				cnt++;
			} else if (last.end > list[i].end) {
				last = list[i];
			}
		}

		return cnt;
	}

	public static class Conference {
		int start;
		int end;

		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
