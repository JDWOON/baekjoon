package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int p = (x - 1) * 30 + y - 1;
		if (x > 10) {
			p += 4;
		} else if (x > 8) {
			p += 3;
		} else if (x > 7) {
			p += 2;
		} else if (x > 5) {
			p += 1;
		} else if (x > 3) {
		} else if (x > 2) {
			p -= 1;
		} else if (x > 1) {
			p += 1;
		}
		p=p%7;
		if(p==0){
			System.out.println("MON");
		}else if(p==1){
			System.out.println("TUE");
		}else if(p==2){
			System.out.println("WED");
		}else if(p==3){
			System.out.println("THU");
		}else if(p==4){
			System.out.println("FRI");
		}else if(p==5){
			System.out.println("SAT");
		}else if(p==6){
			System.out.println("SUN");
		}
	}
}