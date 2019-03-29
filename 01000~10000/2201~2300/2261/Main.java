import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Dot[] dots = new Dot[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			dots[i] = new Dot(x, y);
		}

		Arrays.sort(dots);

		System.out.println(solve(dots, 0, n - 1));
	}

	public static int solve(Dot[] dots, int left, int right) {
		if (right - left == 0) {
			return Integer.MAX_VALUE;
		} else if (right - left == 1) {
			return getDist(dots[right], dots[left], 0);
		} else {
			int mid = (left + right) / 2;
			int result = Math.min(solve(dots, left, mid), solve(dots, mid + 1, right));

			int line = (dots[mid].x + dots[mid + 1].x) / 2;

			ArrayList<Dot> list = new ArrayList<>();

			for (int i = mid + 1; i <= right; i++) {
				if (getDist(new Dot(line, 0), dots[i], 1) >= result) {
					break;
				}
				list.add(dots[i]);
			}

			for (int i = mid; i >= left; i--) {
				if (getDist(new Dot(line, 0), dots[i], 1) >= result) {
					break;
				}

				list.add(dots[i]);
			}

			if (!list.isEmpty()) {
				list.sort((o1, o2) -> (o1.y < o2.y) ? -1 : (o1.y == o2.y) ? 0 : 1);

				for (int i = 0; i < list.size(); ++i) {
					Dot dotA = list.get(i);
					for (int j = i + 1; j < list.size(); j++) {
						Dot dotB = list.get(j);
						if (getDist(dotA, dotB, 2) >= result) {
							break;
						}
						result = Math.min(result, getDist(dotA, dotB, 0));
					}
				}
			}

			return result;
		}
	}

	public static int getDist(Dot a, Dot b, int mode) {
		if (mode == 0) {
			return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		} else if (mode == 1) {
			return (a.x - b.x) * (a.x - b.x);
		} else if (mode == 2) {
			return (a.y - b.y) * (a.y - b.y);
		} else {
			return -1;
		}
	}

	public static class Dot implements Comparable<Dot> {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot o) {
			if (this.x == o.x) {
				return Integer.compare(this.y, o.y);
			} else {
				return Integer.compare(this.x, o.x);
			}
		}
	}
}