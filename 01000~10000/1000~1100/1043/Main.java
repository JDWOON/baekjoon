import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[n];

		for (int i = 0; i < cnt; i++) {
			check[Integer.parseInt(st.nextToken()) - 1] = true;
		}

		boolean[][] conn = new boolean[n][n];

		ArrayList<Integer>[] party = new ArrayList[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());

			party[i] = new ArrayList<Integer>();

			for (int j = 0; j < cnt; j++) {
				party[i].add(Integer.parseInt(st.nextToken()) - 1);
			}

			for (int j = 0; j < party[i].size(); j++) {
				for (int k = j + 1; k < party[i].size(); k++) {
					conn[party[i].get(j)][party[i].get(k)] = true;
					conn[party[i].get(k)][party[i].get(j)] = true;
				}
			}
		}

		boolean[] noLieList = getNoLieList(n, check, conn);

		int result = 0;

		for (int i = 0; i < m; i++) {
			boolean canLie = true;
			for (int temp : party[i]) {
				if (noLieList[temp]) {
					canLie = false;
					break;
				}
			}

			if (canLie) {
				result++;
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}

	public static boolean[] getNoLieList(int n, boolean[] check, boolean[][] conn) {
		boolean[] isVisit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (check[i]) {
				visit(n, check, conn, isVisit, i);
			}
		}

		return isVisit;
	}

	public static void visit(int n, boolean[] check, boolean[][] conn, boolean[] isVisit, int now) {
		if (!isVisit[now]) {
			isVisit[now] = true;

			for (int i = 0; i < n; i++) {
				if (!isVisit[i] && conn[now][i]) {
					visit(n, check, conn, isVisit, i);
				}
			}
		}
	}
}