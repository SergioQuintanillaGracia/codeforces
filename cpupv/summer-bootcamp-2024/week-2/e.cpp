#include <iostream>

int main() {
    long long a, b, c;
    std::cin >> a >> b >> c;
    
    long long x = a & b;
    long long y = x | c;
    long long z = y ^ b;
    std::cout << x << '\n' << y << '\n' << z;

    return 0;
}