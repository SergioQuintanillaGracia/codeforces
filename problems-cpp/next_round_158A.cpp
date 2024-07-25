#include <iostream>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    int points[n];
    int pointsLimit;
    int advanceCount = 0;

    for (int i = 0; i < n; i++) {
        cin >> points[i];
    }

    pointsLimit = points[k - 1];

    for (int i = 0; i < sizeof(points) / sizeof(int); i++) {
        if (points[i] >= pointsLimit && points[i] > 0) {
            advanceCount++;
        
        } else break;
    }

    cout << advanceCount;

    return 0;
}