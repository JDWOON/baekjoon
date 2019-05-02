import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] p = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(p, 0, n - 1, k - 1) + "\n");
		bw.flush();
	}

	public static int solve(int[] list, int left, int right, int k) {
		if (left == right) {
			return list[left];
		}

		Random r = new Random();
		int pivot = left + r.nextInt(right - left);
		pivot = partition(list, left, right, pivot);

		if (k == pivot) {
			return list[k];
		} else if (k < pivot) {
			return solve(list, left, pivot - 1, k);
		} else {
			return solve(list, pivot + 1, right, k);
		}
	}

	public static int partition(int[] list, int left, int right, int pivot) {
		int val = list[pivot];

		int temp = list[pivot];
		list[pivot] = list[right];
		list[right] = temp;

		int now = left;
		for (int i = left; i < right; i++) {
			if (list[i] <= val) {
				temp = list[i];
				list[i] = list[now];
				list[now] = temp;
				now++;
			}
		}

		temp = list[now];
		list[now] = list[right];
		list[right] = temp;

		return now;
	}
}