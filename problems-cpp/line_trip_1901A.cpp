#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    for (int i = 0; i < t; i++) {
        int n, end;
        cin >> n >> end;

        int maxDist = 1;
        int prevDist = 0;

        for (int j = 0; j < n; j++) {
            int gas;
            cin >> gas;

            int dist = gas - prevDist;
            if (dist >= maxDist) maxDist = dist;

            prevDist = gas;
        }

        int lastDist = (end - prevDist) * 2;
        if (lastDist >= maxDist) maxDist = lastDist;

        cout << maxDist << endl;
        maxDist = 1;
    }

    return 0;
}