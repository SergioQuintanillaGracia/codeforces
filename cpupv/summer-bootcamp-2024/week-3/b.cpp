#include <iostream>
#include <iomanip>

int main() {
    long long n, d;
    char o;
    std::cin >> n >> o >> d;
    
    if (o == '+')
        std::cout << n + d;
    
    else if (o == '-')
        std::cout << n - d;
    
    else if (o == '*')
        std::cout << n * d;
    
    else if (o == '/') {
        if (d != 0) {
            std::cout << std::fixed << std::setprecision(2) << ((double) n) / d;
        } else {
            std::cout << "ERROR";
        }
    }

    return 0;
}