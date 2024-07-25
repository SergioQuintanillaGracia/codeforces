// DOES NOT WORK, I HAD NO TIME TO FINISH IT

#include <iostream>

using namespace std;

int main() {
    int cases;
    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int nums;
        cin >> nums;

        int remainder = -1;
        int max_sum = 0;
        int sum = 0;
        
        for (int j = 0; j < nums; j++) {
            int current;
            int prev = 0;
            cin >> current;

            if (abs(current % 2) != abs(remainder)) {
                if (prev >= 0) {
                    remainder = abs(current % 2);
                    sum += current;
                
                }

                prev = current;

            } else {
                sum = current;
                remainder = -1;
            }

            if (sum > max_sum) max_sum = sum;
        }

        cout << max_sum << endl;
        max_sum = 0;
        remainder = -1;
    }

    return 0;
}