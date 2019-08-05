import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Dot[] list = new Dot[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[i] = new Dot(x, y);
		}

		Arrays.sort(list, new Comparator<Dot>() {
			public int compare(Dot o1, Dot o2) {
				return o1.x == o2.x ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x);
			}
		});

		for (int i = 0; i < n; i++) {
			bw.write(list[i].x + " " + list[i].y + "\n");
		}

		bw.flush();
	}

	public static class Dot {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
