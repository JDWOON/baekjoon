import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> xList = new ArrayList<Integer>();
		ArrayList<Integer> yList = new ArrayList<Integer>();

		xList.add(0);
		xList.add(x);
		yList.add(0);
		yList.add(y);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 0) {
				yList.add(b);
			} else if (a == 1) {
				xList.add(b);
			}
		}

		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};

		xList.sort(comp);
		yList.sort(comp);

		int xMax = 0, yMax = 0;

		for (int i = 0; i < xList.size() - 1; i++) {
			xMax = Math.max(xMax, xList.get(i + 1) - xList.get(i));
		}

		for (int i = 0; i < yList.size() - 1; i++) {
			yMax = Math.max(yMax, yList.get(i + 1) - yList.get(i));
		}

		bw.write((xMax * yMax) + "\n");
		bw.flush();
	}
}
