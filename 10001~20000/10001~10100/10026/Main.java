import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static char CHECK = 'X';

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		char[][] rgb = new char[n][n];
		char[][] rb = new char[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			for (int j = 0; j < n; j++) {
				rgb[i][j] = s.charAt(j);
				rb[i][j] = rgb[i][j] == 'G' ? 'R' : rgb[i][j];
			}
		}

		bw.write(getVal(rgb) + " " + getVal(rb) + "\n");

		bw.flush();
	}

	public static int getVal(char[][] map) {
		int result = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != CHECK) {
					result++;
					check(map, i, j, map[i][j]);
				}
			}
		}

		return result;
	}

	public static void check(char[][] map, int x, int y, char now) {
		map[x][y] = CHECK;

		if (x > 0 && map[x - 1][y] == now) {
			check(map, x - 1, y, now);
		}
		if (y > 0 && map[x][y - 1] == now) {
			check(map, x, y - 1, now);
		}
		if (x < map.length - 1 && map[x + 1][y] == now) {
			check(map, x + 1, y, now);
		}
		if (y < map.length - 1 && map[x][y + 1] == now) {
			check(map, x, y + 1, now);
		}
	}
}