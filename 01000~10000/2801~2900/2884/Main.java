import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int result = (h * 60 + m - 45 + (60 * 24)) % (60 * 24);

		bw.write((result / 60) + " " + (result % 60));

		bw.flush();
	}
}