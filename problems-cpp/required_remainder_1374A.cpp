#include <iostream>

int main() {
    int t;
    std::cin >> t;

    for (size_t i = 0; i < t; i++) {
        int x, y, n;
        std::cin >> x >> y >> n;

        int k = n / x * x + y;
        if (k > n) k -= x;

        std::cout << k << '\n';
    }

    return 0;
}