#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void merge(vector<string>& v1, vector<string>& v2, int left, int right) {
	int mid = (left + right) / 2;
	int leftVector = left;
	int rightVector = mid + 1;
	int sortedVector = left;

	while (leftVector <= mid && rightVector <= right) {
		if (v1[leftVector].length() < v1[rightVector].length()) {
			v2[sortedVector] = v1[leftVector];
			sortedVector++;
			leftVector++;
		}
		else if (v1[leftVector].length() == v1[rightVector].length()) {
			if (v1[leftVector] < v1[rightVector]) {
				v2[sortedVector] = v1[leftVector];
				leftVector++;
			}
			else {
				v2[sortedVector] = v1[rightVector];
				rightVector++;
			}
			sortedVector++;
		}
		else
		{
			v2[sortedVector] = v1[rightVector];
			sortedVector++;
			rightVector++;
		}
	}

	int tmp = leftVector > mid ? rightVector : leftVector;

	while (sortedVector <= right) {
		v2[sortedVector++] = v1[tmp++];
	}

	for (int i = left; i <= right; i++)
		v1[i] = v2[i];
}

void mergeSort(vector<string>& v1, vector<string>& v2, int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;
		mergeSort(v1, v2, left, mid);
		mergeSort(v1, v2, mid + 1, right);
		merge(v1, v2, left, right);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int time;
	cin >> time;
	vector<string> words;
	string temp;
	for (int i = 0; i < time; i++) {
		cin >> temp;
		if (find(words.begin(), words.end(), temp) != words.end())
			continue;
		words.push_back(temp);
	}
	vector<string> sorted(words.size());
	mergeSort(words, sorted, 0,words.size() - 1);

	for (string st : words)
		cout << st << '\n';
}