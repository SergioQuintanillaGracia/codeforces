#include <iostream>

int main() {
    int n;
    std::cin >> n;

    int arr[n] = {0};

    for (int i = 0; i < n * 2; i++) {
        int count;
        std::cin >> count;
        arr[i % n] += count;
    }

    for (int i : arr) {
        std::cout << i << ' ';
    }

    return 0;
}