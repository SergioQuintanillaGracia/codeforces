#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int num;
    cin >> num;

    int res = 0;

    while (num > 0) {
        res += num % 2;
        num = num / 2;
    }

    cout << res << endl;

    return 0;
}