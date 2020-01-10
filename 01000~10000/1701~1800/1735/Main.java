import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		bw.write(solve(a, b, c, d));
		bw.flush();
	}

	public static String solve(int a, int b, int c, int d) {
		int x = (a * d) + (c * b), y = b * d;

		for (int i = 2; i <= Math.min(x, y); i++) {
			while (x % i == 0 && y % i == 0) {
				x /= i;
				y /= i;
			}
		}

		return x + " " + y;
	}
}
