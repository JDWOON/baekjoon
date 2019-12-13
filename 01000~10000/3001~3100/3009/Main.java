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
		int[] x = new int[3];
		int[] y = new int[3];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		solve(x, y);
	}

	public static void solve(int[] x, int[] y) throws IOException {
		int mid = -1;

		for (int i = 0; i < 3; i++) {
			int vx1 = x[i] - x[(i + 1) % 3];
			int vy1 = y[i] - y[(i + 1) % 3];
			int vx2 = x[i] - x[(i + 2) % 3];
			int vy2 = y[i] - y[(i + 2) % 3];

			if ((vx1 * vx2) + (vy1 * vy2) == 0) {
				mid = i;
			}
		}

		int dx = x[(mid + 1) % 3] - x[mid];
		int dy = y[(mid + 1) % 3] - y[mid];

		int px = x[(mid + 2) % 3] + dx;
		int py = y[(mid + 2) % 3] + dy;

		bw.write(px + " " + py);
		bw.flush();
	}
}