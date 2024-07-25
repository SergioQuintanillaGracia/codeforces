#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    int sumX = 0, sumY = 0, sumZ = 0;

    cin >> n;

    while(n--) {
        int x, y, z;
        cin >> x >> y >> z;

        sumX += x;
        sumY += y;
        sumZ += z;
    }

    if (sumX == 0 && sumY == 0 && sumZ == 0) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}