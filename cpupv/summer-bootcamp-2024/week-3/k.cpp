#include <iostream>

int main() {
    int t;
    std::cin >> t;

    while (t-- > 0) {
        int n, c;
        bool found = false;
        std::cin >> n >> c;

        while (n-- > 0 && !found) {
            int b;
            std::cin >> b;

            if (b == c) found = true;
        }

        std::cout << (found ? "YES" : "NO") << '\n';
    }

    return 0;
}