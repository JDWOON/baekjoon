import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
			list[i] = new Segment(i, i, val);
		}

		Segment root = Segment.getTree(list);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				long val = c - list[b].sum;
				Segment.changeVal(list[b], val);
			} else if (a == 2) {
				int c = Integer.parseInt(st.nextToken()) - 1;
				bw.write(Segment.getSum(root, b, c) + "\n");
			}
		}

		bw.flush();
	}

	public static class Segment {
		int start, end;
		long sum;
		Segment parent, left, right;

		Segment(int start, int end, long sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}

		public static void makeSegmentParent(Segment[] list, Segment[] dest, int listSize) {
			for (int i = 0; i < (listSize + 1) / 2; i++) {
				if (i == (listSize + 1) / 2 - 1 && listSize % 2 == 1) {
					Segment temp = new Segment(list[i * 2].start, list[i * 2].end, list[i * 2].sum);
					list[i * 2].parent = temp;
					temp.left = list[i * 2];
					temp.right = null;
					dest[i] = temp;
				} else {
					Segment temp = new Segment(list[i * 2].start, list[i * 2 + 1].end,
							list[i * 2].sum + list[i * 2 + 1].sum);
					list[i * 2].parent = temp;
					list[i * 2 + 1].parent = temp;
					temp.left = list[i * 2];
					temp.right = list[i * 2 + 1];
					dest[i] = temp;
				}
			}
		}

		public static Segment getTree(Segment[] list) {
			Segment[] tempList = new Segment[(list.length + 1) / 2];
			makeSegmentParent(list, tempList, list.length);

			int size = tempList.length;

			while (size > 1) {
				makeSegmentParent(tempList, tempList, size);
				size = (size + 1) / 2;
			}

			return tempList[0];
		}

		public static long getSum(Segment now, int start, int end) {
			if (now == null || now.end < start || now.start > end) {
				return 0;
			} else if (start <= now.start && end >= now.end) {
				return now.sum;
			} else {
				return getSum(now.left, start, end) + getSum(now.right, start, end);
			}
		}

		public static void changeVal(Segment now, long val) {
			while (now != null) {
				now.sum += val;
				now = now.parent;
			}
		}
	}
}
