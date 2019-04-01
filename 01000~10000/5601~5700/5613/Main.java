import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = Integer.parseInt(br.readLine());

		while (true) {
			String cal = br.readLine();
			if (cal.equals("=")) {
				break;
			} else {
				int next = Integer.parseInt(br.readLine());

				if (cal.equals("+")) {
					result += next;
				} else if (cal.equals("-")) {
					result -= next;
				} else if (cal.equals("*")) {
					result *= next;
				} else if (cal.equals("/")) {
					result /= next;
				}
			}
		}

		System.out.println(result);
	}
}