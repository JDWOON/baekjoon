package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[] arr = new int[n];
		ArrayList<Integer> idx = new ArrayList<Integer>();

		s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
			idx.add(i);
		}

		idx.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(arr[o1], arr[o2]);
			}
		});

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);

			int p = 0, val = 0;

			for (int j = 0; j < idx.size(); j++) {
				if (idx.get(j) >= a - 1 && idx.get(j) <= b - 1) {
					p++;
				}
				if (p == k) {
					val = arr[idx.get(j)];
					break;
				}
			}

			System.out.println(val);
		}
	}
}