import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();

		boolean[] isPrime = new boolean[4000001];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= 2000; i++) {
			for (int j = 2; i * j < isPrime.length; j++) {
				isPrime[i * j] = false;
			}
		}

		int result = 0;

		for (int i = a; i <= b; i++) {
			if (isPrime[i] && Integer.toString(i).contains(Integer.toString(d))) {
				result++;
			}
		}

		System.out.println(result);
	}
}