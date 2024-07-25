#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int cases;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        long t1, t2, t3;
        long smaller, bigger, middle, difference;

        cin >> t1 >> t2 >> t3;

        smaller = min(min(t1, t2), t3);
        bigger = max(max(t1, t2), t3);
        middle = t1 + t2 + t3 - smaller - bigger;
        difference = bigger + middle - smaller;

        if ((t1 + t2 + t3) % 3 == 0 && difference % 3 == 0 && difference / 3 <= smaller) {
            cout << "YES" << endl;
        
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}