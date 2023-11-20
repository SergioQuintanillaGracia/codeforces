#include <iostream>
#include <vector>

using namespace std;

int main() {
    int cases;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int count, num;
        vector<int> arr;

        cin >> count;

        for (int j = 0; j < count; j++) {
            cin >> num;
            arr.push_back(num);
        }

        vector<int> b = generateB(arr);

        int passedConditions = checkFirst(arr) + check_second(arr) + check_third(arr);

        if (passedConditions == 2) {
            for (int j : b) {
                cout << j << " ";
            }
        
        } else {
            cout << -1 << endl;
        }

        arr.clear();
    }

    return 0;
}


vector<int> generateB(vector<int> a) {
    vector<int> b(a.size(), 0);

    for (int i = 0; i < a.size(); i++) {
        for (int j = 0; j < a.size(); j++) {
            if (a[i] == a[j]) {
                b[i] == 1;
                b[j] == 2;
            }
        }
    }
}


int checkFirst(vector<int> arr) {
    return 0;
}