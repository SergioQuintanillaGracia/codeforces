#include <iostream>
#include <cmath>

int main() {
    int n;
    std::cin >> n;

    while (n-- > 0) {
        int f;
        std::cin >> f;

        if (f == 1) {
            double r;
            std::cin >> r;
            std::cout << 3.141592 * pow(r, 2);
        
        } else if (f == 2) {
            double x;
            std::cin >> x;
            std::cout << pow(x, 2);
        
        } else if (f == 3) {
            double x, y;
            std::cin >> x >> y;
            std::cout << x * y;
        
        } else {
            double b, a;
            std::cin >> b >> a;
            std::cout << b * a / 2;
        }

        std::cout << '\n';
    }

    return 0;
}