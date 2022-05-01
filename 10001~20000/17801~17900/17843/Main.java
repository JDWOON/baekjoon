import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double h = Double.parseDouble(st.nextToken());
			double m = Double.parseDouble(st.nextToken());
			double s = Double.parseDouble(st.nextToken());

			double a = (30 * h) + (0.5 * m) + (0.5 / 60 * s);
			double b = (6 * m) + (0.1 * s);
			double c = 6 * s;

			double ab = Math.min((a - b + 360) % 360, (b - a + 360) % 360);
			double bc = Math.min((b - c + 360) % 360, (c - b + 360) % 360);
			double ca = Math.min((c - a + 360) % 360, (a - c + 360) % 360);

			double result = Math.min(Math.min(ab, bc), ca);

			bw.write(result + "\n");
		}

		bw.flush();
	}
}