import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] p = new int[(1 << n) - 1][2];

		solve(n, p);

		bw.write((1 << n) - 1 + "\n");

		for (int i = 0; i < p.length; i++) {
			bw.write(p[i][0] + " " + p[i][1] + "\n");
		}

		bw.flush();
	}

	public static void solve(int n, int[][] p) {
		p[0][0] = 1;
		p[0][1] = 3;

		for (int i = 2; i <= n; i++) {
			int idx = 0;

			for (int j = 0; j < (1 << (i - 1)) - 1; j++) {
				p[idx][0] = p[j][0] == 1 ? 1 : (p[j][0] == 2 ? 3 : 2);
				p[idx][1] = p[j][1] == 1 ? 1 : (p[j][1] == 2 ? 3 : 2);
				idx++;
			}

			p[idx][0] = 1;
			p[idx][1] = 3;
			idx++;

			for (int j = 0; j < (1 << (i - 1)) - 1; j++) {
				p[idx][0] = p[j][0] == 1 ? 2 : (p[j][0] == 2 ? 3 : 1);
				p[idx][1] = p[j][1] == 1 ? 2 : (p[j][1] == 2 ? 3 : 1);
				idx++;
			}
		}

	}
}
