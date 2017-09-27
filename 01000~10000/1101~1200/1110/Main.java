package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 1;
		int temp = n;
		for (result = 1; result < 100; result++) {
			temp = (temp % 10 * 10) + (temp / 10 + temp % 10) % 10;
			if(temp==n){
				break;
			}
		}
		System.out.println(result);
	}
}