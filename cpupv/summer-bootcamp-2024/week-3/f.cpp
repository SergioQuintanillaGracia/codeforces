#include <iostream>

int main() {
    int prev = -1;
    int e;

    while (std::cin >> e) {
        if (prev != -1) {
            if (prev > e)
                std::cout << 'B';
            else if (prev < e)
                std::cout << 'S';
            else
                std::cout << 'I';
        }

        prev = e;
    }

    return 0;
}