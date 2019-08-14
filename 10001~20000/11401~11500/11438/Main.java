import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		tree = new Node[n + 1];

		for (int i = 1; i < n + 1; i++) {
			tree[i] = new Node();
			tree[i].num = i;
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].link.add(tree[b]);
			tree[b].link.add(tree[a]);
		}

		tree[1].level = 1;
		Node.initTree(tree[1]);

		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(Node.lca(tree[a], tree[b]) + "\n");
		}

		bw.flush();
	}

	public static class Node {
		Node[] parent = new Node[20];
		ArrayList<Node> link = new ArrayList<Node>();
		int num, level;

		public static void initTree(Node now) {
			for (int i = 0; i < now.parent.length - 1; i++) {
				if (now.parent[i] == null || now.parent[i].parent[i] == null) {
					break;
				} else {
					now.parent[i + 1] = now.parent[i].parent[i];
				}
			}

			for (Node child : now.link) {
				child.link.remove(now);
				child.parent[0] = now;
				child.level = now.level + 1;
				initTree(child);
			}
		}

		public static int lca(Node a, Node b) {
			while (a.level > b.level) {
				a = getAncestor(a, b.level);
			}

			while (a.level < b.level) {
				b = getAncestor(b, a.level);
			}

			if (a.num != b.num) {
				int next = 0;

				for (int i = 1; i < a.parent.length - 1; i++) {
					if (a.parent[i] == null || b.parent[i] == null || a.parent[i] == b.parent[i]) {
						next = i - 1;
						break;
					}
				}

				return lca(a.parent[next], b.parent[next]);
			} else {
				return a.num;
			}

		}

		public static Node getAncestor(Node now, int level) {
			if (now.level < level) {
				return null;
			} else if (now.level == level) {
				return now;
			} else {
				while (now.level > level) {
					int next = 0;

					for (int i = 0; i < 20; i++) {
						if (pow(2, i) > now.level - level) {
							next = i - 1;
							break;
						}
					}

					now = now.parent[next];
				}

				return now;
			}
		}
	}

	public static int pow(int a, int b) {
		int result = 1;

		for (int i = 0; i < b; i++) {
			result *= a;
		}

		return result;
	}
}
