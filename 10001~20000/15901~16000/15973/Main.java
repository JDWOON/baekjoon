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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] x = new int[4];
		int[] y = new int[4];

		x[0] = Integer.parseInt(st.nextToken());
		y[0] = Integer.parseInt(st.nextToken());
		x[1] = Integer.parseInt(st.nextToken());
		y[1] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		x[2] = Integer.parseInt(st.nextToken());
		y[2] = Integer.parseInt(st.nextToken());
		x[3] = Integer.parseInt(st.nextToken());
		y[3] = Integer.parseInt(st.nextToken());

		String result = new String();

		if (x[1] < x[2] || x[3] < x[0] || y[1] < y[2] || y[3] < y[0]) {
			result = "NULL";
		} else if ((x[1] == x[2] || x[3] == x[0]) && (y[1] == y[2] || y[3] == y[0])) {
			result = "POINT";
		} else if (x[1] == x[2] || x[3] == x[0] || y[1] == y[2] || y[3] == y[0]) {
			result = "LINE";
		} else {
			result = "FACE";
		}

		bw.write(result);

		bw.flush();
	}
}