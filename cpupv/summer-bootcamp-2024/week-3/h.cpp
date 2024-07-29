#include <iostream>

int main() {
    int n;
    std::cin >> n;

    int max = -1000;
    int min = 1000;

    while (n-- > 0) {
        int p;
        std::cin >> p;

        if (p > max) max = p;
        if (p < min) min = p;
    }

    std::cout << min << " " << max;

    return 0;
}