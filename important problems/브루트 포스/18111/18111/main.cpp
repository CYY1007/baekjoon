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
	* 풀이 1
	* 기준 : 각 칸수를 기준으로 그 칸에 맞춰서 땅의 높이를 맞춘다고 생각
	* -> for문 4번 중첩, 느림
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
		풀이 2
		기준을 다르게, 최대높이가 256이니까
		모든 땅들을 높이 0 ~ 256까지 한다고 생각
		높이 0 ~ 256 속에
		각 칸수 루프 -> 3중 for 조금 더 빠를 것이라 생각
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