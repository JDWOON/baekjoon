package baekjoon;

public class Main {
	public static void main(String[] args) {
		boolean[] p = new boolean[10001];

		for (int i = 0; i < p.length; i++) {
			p[i] = true;
		}

		for (int i = 1; i <= 10000; i++) {
			int temp = i + i / 1000 % 10 + i / 100 % 10 + i / 10 % 10 + i % 10;
			while (temp <= 10000) {
				if (p[temp]) {
					p[temp] = false;
					temp = temp + temp / 1000 % 10 + temp / 100 % 10 + temp / 10 % 10 + temp % 10;
				} else {
					break;
				}
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(p[i]){
				System.out.println(i);
			}
		}
	}
}