#include<iostream>
using namespace std;

void printStars(int row, int col, int n){
	if (n == 1)
		cout << '*';
	else if ((row / (n / 3)) % 3 == 1 && (col / (n / 3)) % 3 == 1)
		cout << ' ';
	else
		printStars(row, col, n / 3);
}

void stars(int n) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printStars(i, j, n);
		}
		cout << '\n';
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	stars(n);
}