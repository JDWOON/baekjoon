#include <iostream>
#include <string>
using namespace std;

const long long mod = 1000000007;

long long getVal(long long a, long long b, long long x, long long y, long long m);
long long powMod(long long x, long long pow);

int main() {
	std::ios_base::sync_with_stdio(false);
	long long a, b, n;
	cin >> a >> b >> n;

	for (long long i = 0; i < n; i++) {
		long long x, y, m;
		cin >> x >> y >> m;

		long long temp = getVal(a, b, x, y, m);
		printf("%d\n", (int)temp);
	}
	return 0;
}

long long getVal(long long a, long long b, long long x, long long y, long long m) {
	long long val = 1, ta, tb, tdiv;
	long long top = (powMod(a, (x - y) % (mod - 1)) * powMod(b, (y - 1) % (mod - 1))) % mod;

	if (a == 1 && b == 1) {
		val = (m % mod) * ((m + 1) % mod) / 2;
	}
	else if (a == 1) {
		tb = ((powMod(b, m % (mod - 1)) - 1) * b - ((m % mod) * b) % mod + (m % mod) + mod) % mod;
		tdiv = ((b - 1) * (b - 1)) % mod;
		tdiv = powMod(tdiv, mod - 2);
		val = (tb * tdiv) % mod;
	}
	else if (b == 1) {
		ta = ((powMod(a, m % (mod - 1)) - 1) * a - ((m % mod) * a) % mod + (m % mod) + mod) % mod;
		tdiv = ((a - 1) * (a - 1)) % mod;
		tdiv = powMod(tdiv, mod - 2);
		val = (ta * tdiv) % mod;
	}
	else if (a == b) {
		ta = (a * (m % mod) - (m % mod) - 1 + mod) % mod;
		ta = (ta * powMod(a, m % (mod - 1)) + 1) % mod;
		tdiv = ((a - 1) * (a - 1)) % mod;
		tdiv = powMod(tdiv, mod - 2);
		val = (ta * tdiv) % mod;
	}
	else {
		ta = (powMod(a, (m + 1) % (mod - 1)) * (b - 1)) % mod;
		tb = (powMod(b, (m + 1) % (mod - 1)) * (a - 1)) % mod;
		tdiv = ((a - 1) * (b - 1)) % mod;
		if (a > b) {
			tdiv = (tdiv * (a - b)) % mod;
			val = (ta - tb + a - b + mod) % mod;
		}
		else {
			tdiv = (tdiv * (b - a)) % mod;
			val = (tb - ta + b - a + mod) % mod;
		}
		tdiv = powMod(tdiv, mod - 2);
		val = (val * tdiv) % mod;
	}
	val = (val * top) % mod;
	return val;
}

long long powMod(long long x, long long pow) {
	long long result = 1;
	while (pow > 0) {
		if (pow % 2 == 1) {
			result = (result * x) % mod;
		}
		x = (x * x) % mod;
		pow /= 2;
	}
	return result;
}