import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static ArrayList<Dot> p = new ArrayList<Dot>();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		p.add(new Dot(0, 0));

		bw.write(solve(0, new Dot(0, 1), 0) + "\n");
		bw.flush();
	}

	public static int solve(int move, Dot now, int prev) {
		if (move > n) {
			return 0;
		} else {
			for (Dot d : p) {
				if (d.x == now.x && d.y == now.y) {
					return move == n ? 1 : 0;
				}
			}

			p.add(now);

			int result = 0;
			if (prev != 1) {
				result += solve(move + 1, new Dot(now.x, now.y + 1), 0);
			}
			if (prev != 0) {
				result += solve(move + 1, new Dot(now.x, now.y - 1), 1);
			}
			if (prev != 2) {
				result += solve(move + 1, new Dot(now.x + ((move % 2) * 2 - 1), now.y), 2);
			}

			p.remove(p.size() - 1);

			return result;
		}
	}

	static class Dot {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
