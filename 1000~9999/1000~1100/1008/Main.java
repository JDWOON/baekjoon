package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = sc.nextInt() * Math.pow(10, 9);
		double b = sc.nextInt();
		double result = Math.round(a / b) / Math.pow(10, 9);
		System.out.println(result);
	}
}