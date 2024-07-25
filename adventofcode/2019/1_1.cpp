#include <bits/stdc++.h>

using namespace std;

int main() {
    int sum = 0;
    int num;

    while (cin >> num) {
        sum += num / 3 - 2;
    }

    cout << sum << endl;

    return 0;
}