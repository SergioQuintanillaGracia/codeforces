#include <iostream>

int main() {
    long long n;
    int k;
    std::cin >> n >> k;
    std::cout << (n << k) << '\n' << (n >> k);

    return 0;
}