import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();

		long now = y * 100 / x;

		if (now >= 99) {
			System.out.println(-1);
		} else {
			System.out.println((long) Math.ceil((double) ((now + 1) * x - 100 * y) / (double) (99 - now)));
		}
	}
}