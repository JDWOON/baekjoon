import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Member[] arr = new Member[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Member(age, i, name);
		}

		Arrays.sort(arr);

		for (Member m : arr) {
			bw.write(m.age + " " + m.name + "\n");
		}

		bw.flush();

	}

	static class Member implements Comparable<Member> {
		int age, id;
		String name;

		Member(int age, int id, String name) {
			this.age = age;
			this.id = id;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			int result = Integer.compare(this.age, o.age);
			result = result == 0 ? Integer.compare(this.id, o.id) : result;
			return result;
		}
	}
}
