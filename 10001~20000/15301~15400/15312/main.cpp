#include <iostream>
#include <string>
using namespace std;

int main() {
	int p[] = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
	string a, b;
	getline(cin, a);
	getline(cin, b);
	int *val = new int[a.length() * 2];

	for (int i = 0; i < a.length(); i++) {
		val[i * 2] = p[(int)(a[i] - 'A')];
		val[i * 2 + 1] = p[(int)(b[i] - 'A')];
	}

	for (int i = a.length() * 2; i > 2; i--) {
		for (int j = 0; j < i - 1; j++) {
			val[j] = (val[j] + val[j + 1]) % 10;
		}
	}

	cout << val[0] << val[1] << endl;

	return 0;
}