#include <iostream>

using namespace std;

int main() {
    long w = 0;
    int testCases;
    long polyStrength = 0;
    int polyEndurance = 0;
    int strength;
    int endurance;

    cin >> testCases;

    for (int i = 0; i < testCases; i++) {
        int athleteCount;
        cin >> athleteCount;

        for (int j = 0; j < athleteCount; j++) {
            if (j == 0) {  //The first test case, which is always Polycarp, the one who should win.
                cin >> polyStrength >> polyEndurance;
                w = polyStrength;
            
            } else {
                cin >> strength >> endurance;

                if (strength >= polyStrength) {  // Here we are comparing the strength.
                    if (endurance >= polyEndurance) {  // Here we are comparing the endurance.
                        w = -1;
                        break;
                    }
                }
            }
        }

        cout << w << endl;
    }

    return 0;
}