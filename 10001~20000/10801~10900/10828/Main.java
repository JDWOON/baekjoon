package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<Integer> list = new LinkedList<Integer>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			switch (s[0]) {
			case "push":
				list.add(Integer.parseInt(s[1]));
				break;
			case "pop":
				bw.write(list.isEmpty() ? "-1" : Integer.toString(list.removeLast()));
				bw.write("\n");
				break;
			case "size":
				bw.write(Integer.toString(list.size()));
				bw.write("\n");
				break;
			case "empty":
				bw.write(list.isEmpty() ? "1" : "0");
				bw.write("\n");
				break;
			case "top":
				bw.write(list.isEmpty() ? "-1" : Integer.toString(list.getLast()));
				bw.write("\n");
				break;
			default:
				break;
			}
		}

		bw.flush();
	}
}
