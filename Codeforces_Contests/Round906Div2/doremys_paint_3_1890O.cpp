#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int getIndex(vector<int> arr, int num) {
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == num) {
            return i;
        }
    }

    return -1;
}


int main() {
    int cases;
    vector<int> arr;
    vector<int> nums;
    vector<int> numsCount;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int amount;
        int el;

        cin >> amount;

        for (int i = 0; i < amount; i++) {
            cin >> el;

            arr.push_back(el);
        }

        // We count the time each number appears:
        for (int i = 0; i < arr.size(); i++) {
            int index = getIndex(nums, arr[i]);

            if (index == -1) {
                nums.push_back(arr[i]);
                numsCount.push_back(1);
            
            } else {
                numsCount[index]++;
            }
        }

        if (nums.size() >= 3) {
            // If there are 3 types of numbers, the array can't be good.
            cout << "No" << endl;
        
        } else if (nums.size() == 1) {
            // If there is only one type of number, the array is always good.
            cout << "Yes" << endl;

        } else {
            // If there are two types of numbers and the difference between
            // the times the first one is repeated and the second one is
            // repeated is 0 or 1, the array can be good.
            int diff = abs(numsCount[0] - numsCount[1]);

            if (diff == 0 or diff == 1) {
                cout << "Yes" << endl;
            
            } else {
                cout << "No" << endl;
            }
        }

        arr.clear();
        nums.clear();
        numsCount.clear();
    }

    return 0;
}