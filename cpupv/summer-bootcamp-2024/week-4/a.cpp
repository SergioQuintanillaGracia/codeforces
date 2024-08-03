#include <iostream>
#include <unordered_set>

int main() {
    std::unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u'};
    int n;
    std::cin >> n;

    // Clear the newline character in the end of the current line by storing it
    // in a variable that won't be used
    std::string t;
    getline(std::cin, t);

    while (n-- > 0) {
        int vCount = 0;
        int lCount = 0;
        std::string w;
        getline(std::cin, w);

        for (char i : w) {
            if (vowels.count(i)) {
                // i is a vowel
                vCount++;
            }

            if (i != ' ') {
                lCount++;
            }
        }

        std::cout << vCount << ' ' << lCount << '\n';
    }

    return 0;
}