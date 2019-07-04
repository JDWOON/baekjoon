import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int startEven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] listA = new int[n / 2];
		int[] listB = new int[n / 2];

		int a = 0, b = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (i == 0) {
				startEven = temp;
			}

			if ((startEven + temp) % 2 == 0 && a < n / 2) {
				listA[a] = temp;
				a++;
			} else if (b < n / 2) {
				listB[b] = temp;
				b++;
			}
		}

		if (a != b) {
			bw.write("-1");
		} else {
			bw.write(solve(listA, listB));
		}

		bw.flush();
	}

	public static String solve(int[] listA, int[] listB) {
		Arrays.sort(listB);

		int[] leftList = Arrays.copyOfRange(listA, 1, listA.length);

		int[] result = new int[listB.length];
		int idx = 0;

		for (int i = 0; i < listB.length; i++) {
			if (isPrime(listA[0] + listB[i])) {
				int[] rightList = new int[listB.length - 1];
				System.arraycopy(listB, 0, rightList, 0, i);
				System.arraycopy(listB, i + 1, rightList, i, listB.length - i - 1);

				if (isPossible(leftList, rightList)) {
					result[idx] = listB[i];
					idx++;
				}
			}
		}

		String answer = new String();

		for (int i = 0; i < idx; i++) {
			answer += result[i] + " ";
		}

		return idx == 0 ? "-1" : answer;
	}

	public static boolean[][] check;
	public static boolean[] visit;
	public static int[] match;

	public static boolean isPossible(int[] listA, int[] listB) {
		check = new boolean[listA.length][listB.length];
		for (int i = 0; i < listA.length; i++) {
			for (int j = 0; j < listB.length; j++) {
				check[i][j] = isPrime(listA[i] + listB[j]);
			}
		}

		match = new int[listB.length];
		visit = new boolean[listB.length];
		Arrays.fill(match, -1);

		int cnt = 0;

		for (int i = 0; i < listA.length; i++) {
			Arrays.fill(visit, false);

			if (dfs(i)) {
				cnt++;
			}
		}

		return cnt == listB.length;
	}

	public static boolean dfs(int now) {
		if (visit[now]) {
			return false;
		} else {
			visit[now] = true;

			for (int i = 0; i < match.length; i++) {
				if (check[now][i]) {
					if (match[i] == -1 || dfs(match[i])) {
						match[i] = now;

						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i < Math.min(n, 45); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}