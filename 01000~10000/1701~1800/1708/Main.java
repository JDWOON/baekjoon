import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Dot[] dots = new Dot[n];

		Dot d = new Dot(Integer.MAX_VALUE, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			dots[i] = new Dot(x, y);

			if (dots[i].x < d.x) {
				d = new Dot(dots[i].x, dots[i].y);
			} else if (dots[i].x == d.x && dots[i].y < d.y) {
				d = new Dot(dots[i].x, dots[i].y);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(solve(dots, d) + "\n");

		bw.flush();
	}

	public static int solve(Dot[] dots, Dot d) {

		final Dot std = new Dot(d.x, d.y);
		Arrays.sort(dots, new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				if (std.x == o1.x && std.x == o2.x) {
					return Long.compare(o2.y, o1.y);
				} else if (std.x == o1.x) {
					return 1;
				} else if (std.x == o2.x) {
					return -1;
				} else {
					return Long.compare((std.y - o1.y) * (std.x - o2.x),
							(std.y - o2.y) * (std.x - o1.x));
				}
			}
		});

		Stack<Dot> dst = new Stack<Dot>();
		dst.push(std);

		for (Dot dot : dots) {
			if (dst.size() == 1) {
				dst.push(dot);
			} else {
				while (true) {
					Dot top = dst.pop();
					Dot prev = dst.peek();

					Dot vA = new Dot(top.x - prev.x, top.y - prev.y);
					Dot vB = new Dot(dot.x - prev.x, dot.y - prev.y);

					long cp = (vA.x * vB.y) - (vA.y * vB.x);
					if (cp > 0) {
						dst.push(top);
						dst.push(dot);
						break;
					} else if (cp == 0) {
						dst.push(dot);
						break;
					}
				}
			}
		}

		if (dst.size() > 2) {
			dst.pop();
		}

		return dst.size();
	}

	public static class Dot {
		long x;
		long y;

		Dot(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}