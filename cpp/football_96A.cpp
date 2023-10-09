#include <iostream>
#include <string>

using namespace std;

int main() {
    string input;
    char prevChar = '2';
    int count = 0;
    bool isDangerous = false;

    cin >> input;

    for (int i = 0; i < input.length(); i++) {
        if (input.at(i) == prevChar) {
            count++;

            if (count >= 7) {
                isDangerous = true;
                break;
            }
        
        } else {
            prevChar = input[i];
            count = 1;
        }
    }

    cout << (isDangerous ? "YES" : "NO");

    return 0;
}