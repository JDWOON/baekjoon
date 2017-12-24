package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		long x = Math.max(a, b), y = Math.min(a, b);

		while (x % y != 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (long i = 0; i < y; i++) {
			bw.write("1");
		}

		bw.flush();
	}
}