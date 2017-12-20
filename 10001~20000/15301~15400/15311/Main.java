package baekjoon;

public class Main {
	public static void main(String[] args) {
		int n = 2000;
		int[] p = new int[n];
		int k = n / 2;
		for (int i = 0; i < p.length; i++) {
			if (i < k) {
				p[i] = 1;
			} else {
				p[i] = k + 1;
			}
		}
		System.out.println(n);

		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}

	}
}