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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Segment[] list = new Segment[n];

		for (int i = 0; i < n; i++) {
			long val = Long.parseLong(br.readLine());
			list[i] = new Segment(i + 1, i + 1, val);
		}

		Segment root = Segment.makeTree(list);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				Segment.setAdd(root, b, c, d);
			} else if (a == 2) {
				bw.write(Segment.getSum(root, b, c) + "\n");
			}
		}

		bw.flush();
	}

	public static class Segment {
		Segment left, right, parent;
		int start, end;
		long sum, add;

		Segment(int start, int end, long sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}

		public static Segment makeTree(Segment[] list) {
			int len = list.length;

			while (len > 1) {
				int prevLen = len;
				len = (len + 1) / 2;

				for (int i = 0; i < len; i++) {
					if (i * 2 < prevLen - 1) {
						Segment left = list[i * 2], right = list[i * 2 + 1];
						list[i] = new Segment(left.start, right.end, left.sum + right.sum);
						list[i].left = left;
						list[i].right = right;
						left.parent = list[i];
						right.parent = list[i];
					} else {
						Segment left = list[i * 2];
						list[i] = new Segment(left.start, left.end, left.sum);
						list[i].left = left;
						left.parent = list[i];
					}
				}
			}

			return list[0];
		}

		public static long getSum(Segment now, int start, int end) {
			if (now == null || now.end < start || now.start > end) {
				return 0;
			} else if (now.start >= start && now.end <= end) {
				return now.sum + (now.end - now.start + 1) * now.add;
			} else {
				now.sum += (now.end - now.start + 1) * now.add;

				now.left.add += now.add;
				if (now.right != null) {
					now.right.add += now.add;
				}

				now.add = 0;

				return getSum(now.left, start, end) + getSum(now.right, start, end);
			}
		}

		public static void setAdd(Segment now, int start, int end, long val) {
			if (now == null || now.end < start || now.start > end) {
				return;
			} else if (now.start >= start && now.end <= end) {
				now.add += val;
			} else {
				now.sum += (Math.min(now.end, end) - Math.max(now.start, start) + 1) * val;
				setAdd(now.left, start, end, val);
				setAdd(now.right, start, end, val);
			}
		}
	}
}
