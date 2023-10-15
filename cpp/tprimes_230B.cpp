// NOTE: At the moment, this problem produces the time limit exceeded
// error in test 7

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

bool isTPrime(long long num);

int main() {
    long count;

    cin >> count;

    for (int i = 0; i < count; i++) {
        long long num;

        cin >> num;

        if (isTPrime(num)) {
            cout << "YES" << endl;
        
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}


bool isTPrime(long long num) {
    if (num == 1) {
        return false;
    }

    if (num % 3 == 0 && num % 2 == 0) {
        return false;
    }

    long long squareRoot = sqrt(num);

    if (pow(sqrt(num), 2) != num) {
        return false;
    
    } else {
        for (long long i = 2; i <= squareRoot - 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}