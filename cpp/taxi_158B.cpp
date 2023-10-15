// My first 1100 difficulty problem, and it got accepted at first try :)

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    int count;
    int taxiCount = 0;
    int groups3 = 0, groups2 = 0, groups1 = 0;

    cin >> count;

    for (int i = 0; i < count; i++) {
        int tempGroup;
        cin >> tempGroup;

        // Every group of 4 will go in its separate taxi, as its size
        // is already of 4
        if (tempGroup == 4) taxiCount++;
        if (tempGroup == 3) groups3++;
        if (tempGroup == 2) groups2++;
        if (tempGroup == 1) groups1++;
    }

    while (!(groups3 <= 0 && groups2 <= 0 && groups1 <= 0)) {
        if (groups1 <= 0) {
            // Two groups of 2 can go into the same taxi, but groups
            // of three need a taxi for each one
            taxiCount += ceil(groups2 / 2.0) + groups3;
            groups2 = 0;
            groups3 = 0;
        
        } else {
            if (groups3 > 0) {
                // We try to join as many groups of 3 with groups of 1 as possible
                // (a group of 3 and one of 1 can go in the same taxi)
                int minGroups = min(groups3, groups1);
                groups3 -= minGroups;
                groups1 -= minGroups;
                taxiCount += minGroups;
            }

            if (groups1 > 0) {
                // If there are still groups of 1 left, that means there are no more
                // groups of 3. We now send 2 groups of 1 with each group of 2 left
                int minGroups = min(groups2, (int) ceil(groups1 / 2.0));
                groups2 -= minGroups;
                groups1 = groups1 - minGroups < 0 ? 0 : groups1 - minGroups * 2;
                taxiCount += minGroups;

                if (groups1 > 0) {
                    // If there are still groups of 1, we send 4 of them in each taxi.
                    taxiCount += ceil(groups1 / 4.0);
                    groups1 = 0;
                }
            }
        }
    }

    cout << taxiCount << endl;

    return 0;
}