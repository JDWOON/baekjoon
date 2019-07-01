import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());

			minVal = Math.min(minVal, a);
			maxVal = Math.max(maxVal, a);
		}

		bw.write(minVal + " " + maxVal);

		bw.flush();
	}
}