#include <iostream>

int main() {
    int n;
    long long sum = 0;

    while (std::cin >> n) {
        sum += n;
        std::cout << sum << ' ';
    }

    return 0;
}