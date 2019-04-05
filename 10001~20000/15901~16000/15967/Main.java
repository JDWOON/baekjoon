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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q1 = Integer.parseInt(st.nextToken());
		int q2 = Integer.parseInt(st.nextToken());

		SegmentTree tree = new SegmentTree(1, n, 0, 0);
		makeTree(tree);

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			long val = Long.parseLong(st.nextToken());
			setVal(tree, i, val);
		}

		for (int i = 0; i < q2 + q1; i++) {
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());

			if (mode == 1) { // qry
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				bw.write(solve(tree, start, end) + "\n");
			} else if (mode == 2) { // add lazy
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());

				addLazy(tree, start, end, val);
			}
		}

		bw.flush();
	}

	public static long solve(SegmentTree tree, int start, int end) {
		if (tree == null || tree.start > end || tree.end < start) {
			return 0;
		} else {
			tree.propagate();

			if (tree.start >= start && tree.end <= end) {
				return tree.val;
			} else {
				return solve(tree.left, start, end) + solve(tree.right, start, end);
			}
		}
	}

	public static void addLazy(SegmentTree tree, int lazyStart, int lazyEnd, long lazyVal) {
		if (tree != null) {
			tree.propagate();

			if (tree.start >= lazyStart && tree.end <= lazyEnd) {
				tree.lazy += lazyVal;
				tree.propagate();
			} else if (tree.start <= lazyEnd && tree.end >= lazyStart) {
				addLazy(tree.left, lazyStart, lazyEnd, lazyVal);
				addLazy(tree.right, lazyStart, lazyEnd, lazyVal);
				tree.val = tree.left.val + tree.right.val;
			}
		}
	}

	public static void makeTree(SegmentTree tree) {
		if (tree != null && tree.start != tree.end) {
			int mid = (tree.start + tree.end) / 2;

			tree.left = new SegmentTree(tree.start, mid, 0, 0);
			tree.right = new SegmentTree(mid + 1, tree.end, 0, 0);

			makeTree(tree.left);
			makeTree(tree.right);
		}
	}

	public static void setVal(SegmentTree tree, int idx, long val) {
		if (tree != null && tree.start <= idx && tree.end >= idx) {
			tree.val += val;
			setVal(tree.left, idx, val);
			setVal(tree.right, idx, val);
		}
	}

	public static class SegmentTree {
		int start;
		int end;
		long val;
		long lazy;
		SegmentTree left, right;

		public SegmentTree(int start, int end, long val, long lazy) {
			this.start = start;
			this.end = end;
			this.val = val;
			this.lazy = lazy;
		}

		public void propagate() {
			if (lazy == 0) {
				return;
			}

			if (left != null) {
				left.lazy += lazy;
			}

			if (right != null) {
				right.lazy += lazy;
			}

			val += (end - start + 1) * lazy;
			lazy = 0;
		}
	}
}