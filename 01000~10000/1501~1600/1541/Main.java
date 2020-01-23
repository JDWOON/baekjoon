import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> ops = new ArrayList<Integer>();

		setInput(nums, ops, br.readLine());

		bw.write(solve(nums, ops) + "\n");

		bw.flush();
	}

	public static void setInput(ArrayList<Integer> nums, ArrayList<Integer> ops, String s) {
		for (int i = 0; i < s.length(); i++) {
			int now = 0;

			while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') {
				now = now * 10 + (int) (s.charAt(i) - '0');
				i++;
			}

			nums.add(now);

			if (i < s.length()) {
				int oper = s.charAt(i) == '+' ? 0 : 1;
				ops.add(oper);
			}
		}
	}

	public static int solve(ArrayList<Integer> nums, ArrayList<Integer> ops) {
		boolean check = false;
		int result = nums.get(0);

		for (int i = 0; i < ops.size(); i++) {
			check |= ops.get(i) == 1;
			if (check) {
				result -= nums.get(i + 1);
			} else {
				result += nums.get(i + 1);
			}
		}

		return result;
	}

}
