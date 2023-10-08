#include <iostream>

using namespace std;

int main() {
    string input;
    string result;

    cin >> input;    

    for (char i : input) {
        i = tolower(i);

        if (i != 'a' && i != 'o' && i != 'y' && i != 'e' && i != 'u' && i != 'i' && i != '\0') {
            result += ".";
            result += i;
        }
    }

    cout << result;

    return 0;
}