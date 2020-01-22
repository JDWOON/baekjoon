import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] cal = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = solve(a, cal);
		bw.write(result[1] + "\n" + result[0] + "\n");
		bw.flush();
	}

	public static int[] solve(int[] a, int[] cal) {
		int[] result = new int[2];

		ArrayList<Integer> list = new ArrayList<Integer>();

		dfs(a, cal, a[0], 1, list);

		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

		result[0] = list.get(0);
		result[1] = list.get(list.size() - 1);

		return result;
	}

	public static void dfs(int[] a, int[] cal, int nowVal, int idx, ArrayList<Integer> list) {
		if (idx == a.length) {
			list.add(nowVal);
		} else {
			if (cal[0] > 0) {
				cal[0]--;
				dfs(a, cal, nowVal + a[idx], idx + 1, list);
				cal[0]++;
			}

			if (cal[1] > 0) {
				cal[1]--;
				dfs(a, cal, nowVal - a[idx], idx + 1, list);
				cal[1]++;
			}

			if (cal[2] > 0) {
				cal[2]--;
				dfs(a, cal, nowVal * a[idx], idx + 1, list);
				cal[2]++;
			}

			if (cal[3] > 0) {
				cal[3]--;
				dfs(a, cal, nowVal / a[idx], idx + 1, list);
				cal[3]++;
			}
		}
	}
}
