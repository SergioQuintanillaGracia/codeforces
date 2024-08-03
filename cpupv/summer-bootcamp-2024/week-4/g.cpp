#include <iostream>

int main() {
    int n;
    std::cin >> n;
    std::string null;
    getline(std::cin, null);
    
    while (n-- > 0) {
        bool white = true;

        for (int i = 0; i < 8; i++) {
            std::string l;
            getline(std::cin, l);

            for (char c : l) {
                if (white && c == 'B' || !white && c == 'W') {
                    std::cout << 'X';
                } else {
                    std::cout << (white ? 'W' : 'B');
                }
                white = !white;
            }

            std::cout << '\n';
            white = !white;
        }
    }

    return 0;
}