import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		bw.write(solve(1, a, b, c) + "\n");

		bw.flush();
	}

	public static long solve(long now, long a, long b, long c) {
		long temp = a, cnt = 1;

		while (cnt * 2 <= b) {
			temp = (temp * temp) % c;
			cnt *= 2;
		}

		b -= cnt;
		now = (now * temp) % c;

		return b == 0 ? now : solve(now, a, b, c);
	}
}