#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int ground[500][500];
	int N, M, B;
	cin >> N >> M >> B;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			cin >> ground[i][j];
	}
	int maxfloor = -1;
	int mintime = -1;

	/*
	* Ǯ�� 1
	* ���� : �� ĭ���� �������� �� ĭ�� ���缭 ���� ���̸� ����ٰ� ����
	* -> for�� 4�� ��ø, ����
	int standard;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			standard = ground[i][j];
			int time = 0;
			int check = 0;
			for (int o = 0; o < N; o++) {
				for (int k = 0; k < M; k++) {
					if (i == o && k == j)
						continue;
					if (ground[i][j] == ground[o][k])
						continue;
					int temp = ground[o][k] - ground[i][j];
					if (temp < 0)
					{
						time += -temp;
						check += temp;
					}
					else
					{
						time += 2 * temp;
						check += temp;
					}
				}
			}
			if (B + check >= 0) {
				if (mintime == time)
				{
					if (maxfloor < ground[i][j]) {
						mintime = time;
						maxfloor = ground[i][j];
					}
				}
				if (mintime == -1 || mintime > time) {
					mintime = time;
					maxfloor = ground[i][j];
				}
			}

		}
	}
	*/

	/*
		Ǯ�� 2
		������ �ٸ���, �ִ���̰� 256�̴ϱ�
		��� ������ ���� 0 ~ 256���� �Ѵٰ� ����
		���� 0 ~ 256 �ӿ�
		�� ĭ�� ���� -> 3�� for ���� �� ���� ���̶� ����
	*/
	for (int hight = 0; hight <= 256; hight++) {
		int time = 0;
		int check = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp = ground[i][j] - hight;
				if (temp > 0) {
					time += 2 * temp;
					check += temp;
				}
				else {
					time += -temp;
					check += temp;
				}
			}
		}
		if (B + check >= 0) {
			if (mintime == time) {
				if (maxfloor < hight)
					maxfloor = hight;
			}
			if (mintime == -1 || mintime > time) {
				mintime = time;
				maxfloor = hight;
			}
		}
	}

	cout << mintime << ' ' << maxfloor;
}