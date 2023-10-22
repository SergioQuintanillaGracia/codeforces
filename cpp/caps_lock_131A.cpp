// NOTE: This problem is not yet fully done.

#include <iostream>

using namespace std;

int main() {
    string input;
    string output;

    cin >> input;

    if () {  // Check if it only contains uppercase letters or if all letters except for the first one are uppercase
        for (char c : input) {
            if (c >= 41 && c <= 90) {
                output += c + 32;
            
            } else {
                output += c;
            }
        }

        output[0] = output[0] - 32;
    }

    cout << output << endl;

    return 0;
}