#include <iostream>

int main() {
    int sum = 0;
    int n, h;

    std::cin >> n >> h;

    for (size_t i = 0; i < n; i++) {
        int curr;
        std::cin >> curr;

        if (curr > h) {
            sum += 2;
        } else {
            sum++;
        }
    }

    std::cout << sum << std::endl;

    return 0;
}