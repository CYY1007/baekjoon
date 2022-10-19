#include<iostream>
#include<vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	do {
		bool check = true;
		cin >> n;
		if (n == 0)
			break;
		vector<int> arr1;
		vector<int> arr2;
		int tmp = n;
		while (n > 0) {
			arr1.push_back(n % 10);
			n /= 10;
		}
		for (int i = 0; i < arr1.size(); i++) {
			arr2.push_back(arr1.back());
			arr1.pop_back();
		}
		for (int i = 0; i < arr1.size(); i++) {
			if (arr1[i] != arr2[i])
			{
				check = false;
				break;
			}
		}
		string result = check ? "yes" : "no";
		cout << result << '\n';
	} while (true);
}