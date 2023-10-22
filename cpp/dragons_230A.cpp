#include <iostream>
#include <vector>

using namespace std;

int main() {
    int s, n;
    vector<int> dragons;
    vector<int> points;

    cin >> s >> n;

    for (int i = 0; i < n; i++) {
        int tempD, tempP;
        
        cin >> tempD >> tempP;

        dragons.push_back(tempD);
        points.push_back(tempP);
    }

    while (dragons.size() > 0) {
        for (int i = 0; i < dragons.size(); i++) {
            if (dragons[i] < s) {
                s += points[i];
                dragons.erase(dragons.begin() + i);
                points.erase(points.begin() + i);
                break;
            }

            if (i == dragons.size() - 1) {
                cout << "NO" << endl;

                return 0;
            }
        }
    }

    cout << "YES" << endl;

    return 0;
}