#include <iostream>

using namespace std;

int sumDigits(long num);

int main() {
    int cases;
    long x;
    int k;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        cin >> x >> k;

        while (sumDigits(x) % k != 0) {
            x++;
        }

        cout << x << endl;
    }

    return 0;
}


int sumDigits(long num) {
    int sum = 0;

    for (char i : to_string(num)) {
        sum += i - '0';
    }

    return sum;
}