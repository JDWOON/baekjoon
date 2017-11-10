package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// it's not perfect. O(n) is not good.
// 코드를 좀더 수정해야 할 필요가 있음.

public class Main {
	public final static int c1 = 0;
	public final static int c5 = 1;
	public final static int c10 = 2;
	public final static int c25 = 3;
	public final static int c100 = 4;
	public final static int c500 = 5;
	public final static int c1000 = 6;
	public final static int c2000 = 7;
	public final static int c5000 = 8;
	public final static int c10000 = 9;
	public final static int coinLen = 10;
	public final static int[] coinVal = { 1, 5, 10, 25, 100, 500, 1000, 2000, 5000, 10000 };
	public static boolean result = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int caseNum = 1;
		int n = sc.nextInt();

		while (n > 0) {
			int[] bank = new int[coinLen];
			int[] ch = new int[n];

			Arrays.fill(bank, 0);

			for (int i = 0; i < n; i++) {
				int[] temp = new int[coinLen];
				ch[i] = 0;
				ch[i] -= sc.nextInt();
				temp[c1] = sc.nextInt();
				temp[c5] = sc.nextInt();
				temp[c10] = sc.nextInt();
				temp[c25] = sc.nextInt();
				temp[c100] = sc.nextInt();
				temp[c500] = sc.nextInt();
				temp[c1000] = sc.nextInt();
				temp[c2000] = sc.nextInt();
				temp[c5000] = sc.nextInt();
				temp[c10000] = sc.nextInt();
				ch[i] += temp[c1];
				ch[i] += temp[c5] * 5;
				ch[i] += temp[c10] * 10;
				ch[i] += temp[c25] * 25;
				ch[i] += temp[c100] * 100;
				ch[i] += temp[c500] * 500;
				ch[i] += temp[c1000] * 1000;
				ch[i] += temp[c2000] * 2000;
				ch[i] += temp[c5000] * 5000;
				ch[i] += temp[c10000] * 10000;
				bank[c1] += temp[c1];
				bank[c5] += temp[c5];
				bank[c10] += temp[c10];
				bank[c25] += temp[c25];
				bank[c100] += temp[c100];
				bank[c500] += temp[c500];
				bank[c1000] += temp[c1000];
				bank[c2000] += temp[c2000];
				bank[c5000] += temp[c5000];
				bank[c10000] += temp[c10000];
			}

			greedy(bank, ch, c1);
			calSolve(bank, ch, c5);
			greedy(bank, ch, c100);
			greedy(bank, ch, c500);
			calSolve(bank, ch, c1000);
			// check 10000

			String outString = result ? "YES" : "NO";
			System.out.println("Case " + caseNum + ": " + outString);

			caseNum++;
			result = true;

			n = sc.nextInt();
		}
	}

	public static void greedy(int[] bank, int[] debt, int coinType) {
		for (int i = 0; i < debt.length; i++) {
			int temp = (debt[i] % coinVal[coinType + 1]) / coinVal[coinType];
			bank[coinType] -= temp;
			debt[i] -= temp * coinVal[coinType];
		}

		if (bank[coinType] < 0) {
			result = false;
		}

		int temp = bank[coinType] / (coinVal[coinType + 1] / coinVal[coinType]);
		bank[coinType + 1] += temp;
		bank[coinType] = 0;
	}

	public static void calSolve(int[] bank, int[] debt, int coinType) {
		if (!check(bank, debt, 0, coinType, 0, 0, 0)) {
			result = false;
		}

		int temp = bank[coinType] * coinVal[coinType];
		temp += bank[coinType + 1] * coinVal[coinType + 1];
		temp += bank[coinType + 2] * coinVal[coinType + 2];

		bank[coinType + 3] += temp / coinVal[coinType + 3];
	}

	public static boolean check(int[] bank, int[] debt, int user, int coinType, int cnt1, int cnt2, int cnt3) {
		if (cnt1 > bank[coinType] || cnt2 > bank[coinType + 1] || cnt3 > bank[coinType + 2]) {
			return false;
		} else if (user >= debt.length) {
			return true;
		} else {
			int ch = debt[user] % coinVal[coinType + 3];
			debt[user] -= ch;
			boolean result = false;
			for (int c = 0; c * coinVal[coinType + 2] <= ch; c++) {
				for (int b = 0; b * coinVal[coinType + 1] + c * coinVal[coinType + 2] <= ch; b++) {
					int a = (ch - b * coinVal[coinType + 1] - c * coinVal[coinType + 2]) / coinVal[coinType];
					result = check(bank, debt, user + 1, coinType, cnt1 + a, cnt2 + b, cnt3 + c);
					if (result) {
						return result;
					}
				}
			}
			return result;
		}
	}
}