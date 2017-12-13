package baekjoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			HashMap<String, Integer> map = new HashMap();

			for (int j = 0; j < n; j++) {
				String name = sc.next();
				String kind = sc.next();
				if (map.containsKey(kind)) {
					map.put(kind, map.get(kind) + 1);
				} else {
					map.put(kind, 1);
				}
			}

			Set key = map.keySet();
			Iterator iterator = key.iterator();
			int result = 1;

			while (iterator.hasNext()) {
				String kind = (String) iterator.next();
				result *= map.get(kind) + 1;
			}

			System.out.println(result - 1);
		}
	}
}