package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = Integer.toString(sc.nextInt() * sc.nextInt() * sc.nextInt());
		int[] cnt = new int[10];
		
		for(int i=0; i<10; i++){
			cnt[i] = 0;
		}
		
		for(int i=0; i<s.length(); i++){
			cnt[(int)(s.charAt(i)-'0')]++;
		}
		
		for(int i=0; i<10; i++){
			System.out.println(cnt[i]);
		}
		
	}
}