#include <iostream>
#include <cmath>
#include <unordered_set>

using namespace std;

bool containsNum(unordered_set<long long> set, long long num);

int main() {
    int count;
    unordered_set<long long> tprimes;

    // We populate the tprimes set by finding the primes from 2 to 1000000
    // and appending its squares to the set, so that the only divisors they
    // have are 1, num, and sqrt(num).

    tprimes.insert(4);

    for (int i = 2; i <= 1000000; i++) {
        bool isPrime = true;

        for (int j = 2; j <= sqrt(i); j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            tprimes.insert(pow(i, 2));
        
        } else {
            isPrime = true;
        }
    }

    cin >> count;

    // For each num, we check if it's contained in the tprimes set.
    for (int i = 0; i < count; i++) {
        long long num;

        cin >> num;

        if (tprimes.find(num) != tprimes.end()) {
            cout << "YES" << endl;
        
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}