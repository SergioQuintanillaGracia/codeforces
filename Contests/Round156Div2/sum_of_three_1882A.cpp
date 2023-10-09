#include <iostream>

using namespace std;

int main() {
    int cases;
    int solutions[3];

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int num;
        cin >> num;

        if (num >= 7) {
            solutions[0] = 1;
            solutions[1] = 2;
            solutions[2] = num - 3;

            if (solutions[2] % 3 == 0) {
                    solutions[1] += 2;
                    solutions[2] -= 2;
            }

            if (solutions[0] != solutions[1] && solutions[0] != solutions[2] && solutions[1] != solutions[2]) {
                cout << "YES" << endl << solutions[0] << " " << solutions[1] << " " << solutions[2] << endl;
            
            } else {
                cout << "NO" << endl;
            }
        
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}