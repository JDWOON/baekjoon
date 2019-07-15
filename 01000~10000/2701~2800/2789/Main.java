import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] cards = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(solve(cards, m) + "\n");

		bw.flush();
	}

	public static int solve(int[] cards, int m) {
		int sum = 0;

		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					int temp = cards[i] + cards[j] + cards[k];

					if (temp <= m && temp > sum) {
						sum = temp;
					}
				}
			}
		}

		return sum;
	}
}
