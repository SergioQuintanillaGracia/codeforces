#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int cases;
    cin >> cases;

    for (int i = 0; i < cases; i++) {
        long long num;
        cin >> num;

        if (num % 2 != 0 && num > 1) {
            cout << "YES" << endl;
            continue;
        
        } else {
            bool yes = false;

            for (int j = 2; j < sqrt(num) + 1; j++) {
                if (num % j == 0 && j % 2 != 0) {
                    yes = true;
                    break;
                }
            }

            cout << (yes ? "YES" : "NO") << endl;
        }
    }

    return 0;
}