#include <iostream>
#include <vector>

using namespace std;

int isLucky(int num);

int main() {
    int num;
    vector<int> luckyNums;
    
    cin >> num;

    for (int i = 4; i <= 777; i++) {
        if (isLucky(i)) {
            luckyNums.push_back(i);
        }
    }

    for (int i : luckyNums) {
        if (num % i == 0) {
            cout << "YES" << endl;
            return 0;
        }
    }

    cout << "NO" << endl;

    return 0;
}


int isLucky(int num) {
    for (char c : to_string(num)) {
        if (c != '4' && c != '7') {
            return false;
        }
    }

    return true;
}