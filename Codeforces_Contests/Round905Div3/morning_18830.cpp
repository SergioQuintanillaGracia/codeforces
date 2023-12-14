#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int cases;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        string pin;
        int sec = 0;
        int cursor = 1;

        cin >> pin;

        for (char c : pin) {
            int digit = c - '0';
            
            // We will treat 0s as 10s.
            if (digit == 0) digit = 10;

            // We add to sec the difference between the position of the
            // cursor and the digit we want to reach, +1, because it
            // takes a second to input that digit.
            sec += abs(digit - cursor) + 1;
            cursor = digit;
        }

        cout << sec << endl;

        sec = 0;
        cursor = 1;
    }

    return 0;
}