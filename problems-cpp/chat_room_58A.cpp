#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;
    int lastIndex = -1;
    string target = "hello";
    bool saysHello = true;

    cin >> s;

    for (char c : target) {
        size_t charIndex = s.find(c, lastIndex + 1);

        if (charIndex != string::npos) {
            lastIndex = charIndex;

        } else {
            saysHello = false;
            break;
        }
    }

    cout << (saysHello ? "YES" : "NO");

    return 0;
}
