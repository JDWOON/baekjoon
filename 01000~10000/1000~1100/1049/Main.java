import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int oneMin = 1000, sixMin = 1000;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			sixMin = Math.min(sixMin, Integer.parseInt(st.nextToken()));
			oneMin = Math.min(oneMin, Integer.parseInt(st.nextToken()));
		}

		if (oneMin * 6 < sixMin) {
			System.out.println(n * oneMin);
		} else if ((n % 6) * oneMin > sixMin) {
			System.out.println((n / 6 + 1) * sixMin);
		} else {
			System.out.println((n % 6) * oneMin + (n / 6) * sixMin);
		}
	}
}