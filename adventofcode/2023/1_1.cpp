#include <bits/stdc++.h>

using namespace std;

int main() {
    int sum = 0;
    string curr;
    
    while (true) {
        cin >> curr;

        if (curr == "-1") break;

        int currCharInt;
        int first = -1;
        int second;

        for (int i = 0; i < curr.size(); i++) {
            currCharInt = curr.at(i);

            if (currCharInt > 47 && currCharInt < 58) {
                if (first == -1) {
                    first = currCharInt - 48;
                }

                second = currCharInt - 48;
            }
        }

        sum += first * 10 + second;
    }

    cout << sum << endl;

    return 0;
}