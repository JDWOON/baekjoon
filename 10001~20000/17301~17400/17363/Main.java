import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Character, Character> map = new HashMap<>();

		map.put('.', '.');
		map.put('O', 'O');
		map.put('-', '|');
		map.put('|', '-');
		map.put('/', '\\');
		map.put('\\', '/');
		map.put('^', '<');
		map.put('<', 'v');
		map.put('v', '>');
		map.put('>', '^');

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] p = new char[m][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			for (int j = 0; j < m; j++) {
				p[m - j - 1][i] = map.get(s.charAt(j));
			}
		}

		for (char[] line : p) {
			for (char c : line) {
				bw.write(c);
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
