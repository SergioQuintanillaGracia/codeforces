#include <iostream>

int main() {
    int n, m;
    std::cin >> n >> m;

    // We only care about the smallest number (either rows or cols).
    // Each intersection will remove one stick of each type, so when
    // the stick count of the direction with the lower amount of sticks
    // reaches 0, the game ends.
    if ((n < m ? n : m) % 2 == 0) {
        std::cout << "Malvika\n";
    } else {
        std::cout << "Akshat\n";
    }

    return 0;
}