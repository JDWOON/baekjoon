package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Node root = new Node();

		while (sc.hasNext()) {
			root.list.add(sc.nextInt());
		}
		
		root.init();
		
		postOrder(root, bw);

		bw.flush();
	}

	public static void postOrder(Node node, BufferedWriter bw) throws IOException {
		if (node.left != null) {
			postOrder(node.left, bw);
		}
		if (node.right != null) {
			postOrder(node.right, bw);
		}
		bw.write(node.val + "\n");
	}
}

class Node {
	ArrayList<Integer> list = new ArrayList<Integer>();
	Node left = null;
	Node right = null;
	int val = 0;

	public void init() {
		val = list.get(0);
		list.remove(0);
		if (list.size() > 0) {
			if (list.get(0) > val) {
				this.right = new Node();
				right.list.addAll(list);
				right.init();
			} else if (list.get(list.size() - 1) < val) {
				this.left = new Node();
				left.list.addAll(list);
				left.init();
			} else {
				this.left = new Node();
				this.right = new Node();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) < val) {
						left.list.add(list.get(i));
					} else {
						right.list.add(list.get(i));
					}
				}
				left.init();
				right.init();
			}
			list.clear();
		}
	}
}