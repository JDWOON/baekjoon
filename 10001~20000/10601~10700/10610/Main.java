import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		int sum = 0;
		boolean inZero = false;

		for (int i = 0; i < n.length(); i++) {
			sum += (int) (n.charAt(i) - '0');
			inZero = inZero || n.charAt(i) == '0';
		}

		if (sum % 3 == 0 && inZero) {
			char[] cArr = n.toCharArray();
			Arrays.sort(cArr);
			bw.write(new StringBuffer(new String(cArr)).reverse().toString() + "\n");
		} else {
			bw.write("-1");
		}

		bw.flush();
	}
}
