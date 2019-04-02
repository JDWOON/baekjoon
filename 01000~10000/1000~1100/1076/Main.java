import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Long> map = new HashMap();

		map.put("black", 0l);
		map.put("brown", 1l);
		map.put("red", 2l);
		map.put("orange", 3l);
		map.put("yellow", 4l);
		map.put("green", 5l);
		map.put("blue", 6l);
		map.put("violet", 7l);
		map.put("grey", 8l);
		map.put("white", 9l);

		long a = map.get(br.readLine());
		long b = map.get(br.readLine());
		long c = (long) Math.pow(10, (double) map.get(br.readLine()));

		System.out.println((a * 10 + b) * c);
	}
}