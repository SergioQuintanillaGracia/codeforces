#include <iostream>

int main() {
    int t;
    std::cin >> t;

    while (t-- > 0) {
        int n, c;
        bool found = false;
        std::cin >> n >> c;

        while (!found && n-- > 0) {
            int b;
            std::cin >> b;

            if (b == c) {
                found = true;
            }
        }

        while (n-- > 0) {
            // Read the rest of values and discard them by storing them in
            // a variable like c, that won't be used anymore
            std::cin >> c;
        }

        std::cout << (found ? "YES" : "NO") << '\n';
    }

    return 0;
}