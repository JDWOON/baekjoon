import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		ArrayList<Integer>[] child = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			child[i] = new ArrayList<Integer>();
		}

		int root = 0;

		for (int i = 0; i < n; i++) {
			int par = sc.nextInt();
			if (par == -1) {
				root = i;
			} else {
				child[par].add(i);
			}
		}

		int remove = sc.nextInt();

		System.out.println(solve(child, root, remove));
	}

	public static int solve(ArrayList<Integer>[] child, int now, int remove) {
		if (now == remove) {
			return 0;
		} else if (child[now].size() == 0) {
			return 1;
		} else {
			int result = 0;
			for (int i = 0; i < child[now].size(); i++) {
				if (child[now].get(i) == remove) {
					if (child[now].size() == 1) {
						result++;
					}
				} else {
					result += solve(child, child[now].get(i), remove);
				}
			}
			return result;
		}
	}
}