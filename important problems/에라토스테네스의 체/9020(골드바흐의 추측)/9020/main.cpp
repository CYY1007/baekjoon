#include<iostream>
#include<cmath>
#include<vector>
using namespace std;

// °ñµå¹ÙÈåÀÇ ÃßÃø

int main() 
{
	int times;
	cin >> times;
	int* nums = new int[times];
	int getter;
	for (int i = 0; i < times; i++) {
		cin >> getter;
		nums[i] = getter;
	}

	for (int i = 0; i < times; i++) {
		int j = nums[i];
		int* arr = new int[j + 1];
		arr[0] = -1;
		arr[1] = -1;
		for (int i = 2; i <= j; i++)
			arr[i] = 0;
		for (int k = 2; k < sqrt(j); k++) {
			if (arr[k] == -1)
				continue;
			for (int o = k + k; o <= j; o += k) {
				arr[o] = -1;
			}
		}
		vector<int> checker;
		struct least {
			int least;
			int n1;
			int n2;
			bool init;
		};

		least l1 = { 0, 0, 0, true};
		for (int i = 0; i < j; i++)
			if (arr[i] != -1) checker.push_back(i);
		
		for (int i = 0; i < checker.size() - 1; i++) {
			for (int o = i; o < checker.size(); o++) {
				if (checker[i] + checker[o] == j) {
					if (l1.init) {
						l1.least = checker[o] - checker[i];
						l1.n1 = checker[i];
						l1.n2 = checker[o];
						break;
					}
					else {
						if (checker[o] - checker[i] < l1.least) {
							l1.least = checker[o] - checker[i];
							l1.n1 = checker[i];
							l1.n2 = checker[o];
						}
						break;
					}
				}
			}
		}
		cout << l1.n1 << ' ' << l1.n2 << endl;
	}




}