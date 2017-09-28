package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt=0;
		
		for(int i=1; i<=n; i++){
			if(isHanSu(i)){
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static boolean isHanSu(int x) {
		if (x >= 1000) {
			return false;
		} else if (x >= 100) {
			int a = x / 100;
			int b = x / 10 % 10;
			int c = x % 10;
			if (a - b == b - c) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
}