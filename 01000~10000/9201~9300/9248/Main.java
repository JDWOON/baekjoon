package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s = br.readLine().toCharArray();

		int len = s.length;

		Integer[] sa = new Integer[len];

		for (int i = 0; i < len; i++) {
			sa[i] = i;
		}

		getSuffix(s, sa, len);

		int[] la = new int[len];

		getLCP(s, sa, la, len);

		for (int i = 0; i < len; i++) {
			sa[i]++;
		}

		// output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < sa.length; i++) {
			bw.write(sa[i] + " ");
		}
		bw.write("\nx");
		for (int i = 1; i < len; i++) {
			bw.write(" " + la[i]);
		}
		bw.flush();
	}

	public static void getSuffix(char[] s, Integer[] sa, int len) {
		int[] group = new int[len];
		int[] temp = new int[len];

		// first group
		for (int i = 0; i < len; i++) {
			group[i] = (int) (s[i] - 'a');
		}

		for (int i = 1; i <= len; i *= 2) {
			groupSort(sa, group, i);

			temp[sa[0]] = 0;

			for (int j = 1; j < len; j++) {
				if (groupCompare(sa, group, sa[j - 1], sa[j], i) < 0) {
					temp[sa[j]] = temp[sa[j - 1]] + 1;
				} else {
					temp[sa[j]] = temp[sa[j - 1]];
				}
			}
			for (int j = 0; j < len; j++) {
				group[j] = temp[j];
			}
		}
	}

	public static int groupCompare(Integer[] sa, int[] group, int a, int b, int t) {
		if (group[a] == group[b]) {
			if (a + t >= sa.length) {
				return -1;
			} else if (b + t >= sa.length) {
				return 1;
			} else {
				return group[a + t] - group[b + t];
			}
		} else {
			return group[a] - group[b];
		}
	}

	public static void groupSort(Integer[] sa, int[] group, int t) {
		Arrays.sort(sa, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return groupCompare(sa, group, o1, o2, t);
			}
		});
	}

	public static void getLCP(char[] s, Integer[] sa, int[] la, int len) {
		int[] rank = new int[len];

		for (int i = 0; i < len; i++) {
			rank[sa[i]] = i;
		}

		int share = 0;

		for (int i = 0; i < len; i++) {
			int k = rank[i];
			if (k > 0) {
				int j = sa[k - 1];

				while (j + share < len && i + share < len && s[j + share] == s[i + share]) {
					share++;
				}

				la[k] = share;

				if (share > 0) {
					share--;
				}
			}
		}
	}
}