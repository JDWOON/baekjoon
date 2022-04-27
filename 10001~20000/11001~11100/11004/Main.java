import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, n - 1);

		bw.write(arr[k - 1] + "\n");

		bw.flush();
	}

	public static void mergeSort(int[] p, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;

			mergeSort(p, l, mid);
			mergeSort(p, mid + 1, r);

			int[] lArr = Arrays.copyOfRange(p, l, mid + 1);
			int[] rArr = Arrays.copyOfRange(p, mid + 1, r + 1);
			int a = 0, b = 0;

			for (int i = l; i < r + 1; i++) {
				if (a == lArr.length) {
					p[i] = rArr[b];
					b++;
				} else if (b == rArr.length) {
					p[i] = lArr[a];
					a++;
				} else if (lArr[a] < rArr[b]) {
					p[i] = lArr[a];
					a++;
				} else {
					p[i] = rArr[b];
					b++;
				}
			}
		}
	}
}