import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] list = new String[n];

		for (int i = 0; i < n; i++) {
			list[i] = br.readLine();
		}

		if (n == 1) {
			System.out.println(list[0]);
		} else {
			String result = new String();

			for (int i = 0; i < list[0].length(); i++) {
				for (int j = 0; j < n - 1; j++) {
					if (list[j].charAt(i) != list[j + 1].charAt(i)) {
						result += '?';
						break;
					} else if (j == n - 2) {
						result += list[j].charAt(i);
					}
				}
			}

			System.out.println(result);
		}

	}
}