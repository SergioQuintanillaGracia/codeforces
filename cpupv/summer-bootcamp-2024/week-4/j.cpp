#include <iostream>
#include <iomanip>

int main() {
    int n;
    std::cin >> n;

    std::cout << std::setprecision(6) << std::fixed;

    while (n-- > 0) {
        int r, c;
        double e;
        std::cin >> r >> c >> e;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double d;
                std::cin >> d;
                std::cout << (d <= e ? 0 : d) << ' ';
            }
            std::cout << '\n';
        }
    }

    return 0;
}