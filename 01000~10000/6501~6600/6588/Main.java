import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static boolean[] isPrime = new boolean[1000001];
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		initPrime();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			bw.write(solve(n) + "\n");
		}

		bw.flush();
	}

	public static String solve(int num) {
		for (int i = 0; i < list.size(); i++) {
			if (isPrime[num - list.get(i)]) {
				return num + " = " + list.get(i) + " + " + (num - list.get(i));
			}
		}
		return "Goldbach's conjecture is wrong.";
	}

	public static void initPrime() {
		Arrays.fill(isPrime, true);

		for (int i = 2; i < 1000; i++) {
			for (int j = 2; i * j < 1000000; j++) {
				isPrime[i * j] = false;
			}
		}

		for (int i = 2; i < 1000000; i++) {
			if (isPrime[i]) {
				list.add(i);
			}
		}
	}
}