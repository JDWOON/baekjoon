import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] p = new int[26];
		Arrays.fill(p, 0);

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			int tenPow = 1;
			for (int j = 0; j < temp.length(); j++) {
				int x = (int) (temp.charAt(temp.length() - 1 - j) - 'A');
				p[x] += tenPow;
				tenPow *= 10;
			}
		}

		Arrays.sort(p);

		int result = 0;

		for (int i = 0; i < 10; i++) {
			result += (9 - i) * p[p.length - 1 - i];
		}

		bw.write(result + "\n");
		bw.flush();
	}
}