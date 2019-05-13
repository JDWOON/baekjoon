import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		String key = br.readLine();
		String result = new String();

		for (int i = 0; i < text.length(); i++) {
			int j = i % key.length();
			if (text.charAt(i) == ' ') {
				result += ' ';
			} else {
				char get = (char) (((25 + text.charAt(i) - key.charAt(j)) % 26) + 'a');
				result += get;
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}
}