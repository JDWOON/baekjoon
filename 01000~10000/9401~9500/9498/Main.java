package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		if (s <= 100 && s >= 90) {
			System.out.println("A");
		} else if (s <= 89 && s >= 80) {
			System.out.println("B");
		} else if (s <= 79 && s >= 70) {
			System.out.println("C");
		} else if (s <= 69 && s >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}