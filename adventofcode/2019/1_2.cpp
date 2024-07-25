#include <bits/stdc++.h>

using namespace std;


int fuelRecursive(int sum) {
    int newSum = sum / 3 - 2;

    if (newSum > 0) {
        return newSum + fuelRecursive(newSum);
    
    } else {
        return 0;
    }
}


int main() {
    int sum = 0;
    int num;

    while (cin >> num) {
        int addToSum = num / 3 - 2;
        addToSum += fuelRecursive(addToSum);
        sum += addToSum;
    }

    cout << sum << endl;

    return 0;
}