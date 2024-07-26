#include <iostream>

int main() {
    long long n, a, b, c, d;
    std::cin >> n >> a >> b >> c >> d;
    std::cout
        << n + a << '\n'
        << n - b << '\n'
        << n * c << '\n'
        << n / d << '\n'
        << n % d;
    return 0;
}