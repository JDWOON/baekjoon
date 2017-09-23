package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 1; n > 1; n = n / 2 + n % 2) {
			if ((a % 2 == 1 && a + 1 == b) || (a % 2 == 0 && a - 1 == b)) {
				System.out.println(i);
				break;
			}else{
				a = a/2 + a%2;
				b = b/2 + b%2;
				i++;
			}
		}
	}
}