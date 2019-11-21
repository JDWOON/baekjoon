import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		LinkedList<Character> list = new LinkedList<Character>();

		for (Character c : s.toCharArray()) {
			list.add(c);
		}

		ListIterator<Character> iter = list.listIterator(list.size());

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if (command.charAt(0) == 'L' && iter.hasPrevious()) {
				iter.previous();
			} else if (command.charAt(0) == 'D' && iter.hasNext()) {
				iter.next();
			} else if (command.charAt(0) == 'B' && iter.hasPrevious()) {
				iter.previous();
				iter.remove();
			} else if (command.charAt(0) == 'P') {
				iter.add(command.charAt(2));
			}
		}

		for (Character c : list) {
			bw.write(c);
		}

		bw.flush();
	}
}