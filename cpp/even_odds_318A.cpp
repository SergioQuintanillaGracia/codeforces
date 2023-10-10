#include <iostream>
#include <cmath>

using namespace std;

int main() {
    long long n, k;

    cin >> n >> k;

    n = n % 2 == 0 ? n : n + 1;

    if (k <= n / 2) {
        cout << k * 2 - 1;
    
    } else {
        cout << (k - n / 2) * 2;
    }

    return 0;
}