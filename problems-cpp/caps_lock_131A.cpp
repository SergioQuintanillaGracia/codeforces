#include <iostream>

using namespace std;


string invertCase(string str) {
    string res;

    for (char c : str) {
        char newChar;

        if (c >= 97 && c <= 122) {
            newChar = c - 32;
        }
        
        if (c >= 65 && c <= 90) {
            newChar = c + 32;
        }

        res += newChar;
    }

    return res;
}


bool mustInvertCase(string str) {
    for (int i = 1; i < str.length(); i++) {
        if (!(str.at(i) >= 65 && str.at(i) <= 90)) {
            return false;
        }
    }

    return true;
}


int main() {
    string input;
    string output;

    cin >> input;

    if (mustInvertCase(input)) {
        output = invertCase(input);
    
    } else {
        output = input;
    }

    cout << output << endl;

    return 0;
}