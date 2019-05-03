import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		boolean[][] p = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String temp = br.readLine();

			for (int j = 0; j < c; j++) {
				if (temp.charAt(j) == '1') {
					p[i][j] = true;
				} else {
					p[i][j] = false;
				}
			}
		}

		bw.write(solve(p) + "");

		bw.flush();
	}

	public static int solve(boolean[][] p) {
		int result = 0;
		int max = Math.min(p.length, p[0].length);
		max = (max + 1) / 2;

		for (int size = 1; size <= max; size++) {
			boolean check = false;

			for (int px = 0; !check && px + ((size - 1) * 2) < p.length; px++) {
				for (int py = 0; !check && py + ((size - 1) * 2) < p[0].length; py++) {
					int topX = px, topY = py + size - 1;
					int botX = px + size * 2 - 2, botY = py + size - 1;

					boolean isDia = true;

					for (int k = 0; k < size; k++) {
						boolean temp = p[topX + k][topY + k] && p[topX + k][topY - k]
								&& p[botX - k][botY + k] && p[botX - k][botY - k];

						if (!temp) {
							isDia = false;
							break;
						}
					}

					check = isDia;
				}
			}

			if (check) {
				result = size;
			}

		}

		return result;
	}
}