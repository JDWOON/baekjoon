package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		System.out.println(new Main().solve(n));
	}

	public long solve(long n) {
		if (n <= 2) {
			return 1;
		} else if (isPrime(n)) {
			return n - 1;
		} else {
			long div = n;
			long result = 1;

			for (int i = 2; div > 1 && i <= Math.sqrt(n); i++) {
				if (div % i == 0) {
					result *= solve(i);
					div /= i;
					while (div % i == 0) {
						result *= i;
						div /= i;
					}
				}
			}

			return result * solve(div);
		}
	}

	public boolean isPrime(long n) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}