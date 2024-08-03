#include <iostream>
#include <sstream>

void printRepeat(char c, int n) {
    while (n-- > 0) {
        std::cout << c;
    }
    std::cout << '\n';
}

int main() {
    int t;
    std::cin >> t;
    std::string null;
    getline(std::cin, null);

    while (t-- > 0) {
        std::string text;
        getline(std::cin, text);
        int astCount = text.length() * 4 + 1;

        // Use a ostringstream (similar to a java StringBuilder) to build the text output
        // string at the same time we count the necessary asterisks above and below it
        // This way, we only need to iterate through the string one time
        std::ostringstream oss;
        oss << '*';

        for (char c : text) {
            if (c == ' ') {
                oss << "**";
                astCount -= 2;
            } else {
                oss << ' ' << c << " *";
            }
        }

        printRepeat('*', astCount);
        std::cout << oss.str() << '\n';
        printRepeat('*', astCount);
    }

    return 0;
}