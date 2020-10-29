import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());

		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(p, 0, p.length - 1);

		for (int i = 0; i < p.length; i++) {
			bw.write(p[i] + "\n");
		}

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