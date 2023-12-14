#include <iostream>
#include <string>
#include <memory.h>

using namespace std;

int main() {
    string s;
    int arrCounter[10];
    memset(arrCounter, 0, sizeof(arrCounter));

    cin >> s;

    for (int i = 0; i < s.size(); i++) {
        int num = s.at(i) - 48;

        arrCounter[num]++;
    }

    for (int i = 0; i < 10; i++) {
        cout << i << ": " << arrCounter[i] << endl;
    }

    return 0;
}