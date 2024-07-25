#include <iostream>
#include <vector>

using namespace std;

int main() {
    string input;
    vector<char> instructions {'H', 'Q', '9'};

    cin >> input;

    for (char c : input) {
        for (char i : instructions) {
            if (c == i) {
                cout << "YES" << endl;
                return 0;
            }
        }
    }

    cout << "NO" << endl;

    return 0;
}