#include <iostream>
#include <cmath>

int main() {
    int n, p;
    std::cin >> n >> p;

    while (p-- > 0) {
        int g, diff;
        std::cin >> g;
        diff = abs(g - n);

        if (diff == 0)
            std::cout << "1p ";
        
        else if (diff <= 5)
            std::cout << "0.5p ";
        
        else if (diff <= 10)
            std::cout << "0.25p ";
        
        else
            std::cout << "0p ";
    }

    return 0;
}