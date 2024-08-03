#include <iostream>

int main() {
    int r, c;
    std::cin >> r >> c;

    // Arrays that store whether certain x and y positions will have water or not
    bool x[r] = {false};
    bool y[c] = {false};

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            char ch;
            std::cin >> ch;

            if (ch == '#') {
                x[i] = true;
                y[j] = true;
            }
        }
    }

    for (int i = 0; i < r; i++) {
        if (x[i]) {
            // The entire row contains water
            for (int j = 0; j < c; j++) {
                std::cout << '#';
            }
        } else {
            // Check for every position in the row individually if it should
            // contain water
            for (int j = 0; j < c; j++) {
                std::cout << (y[j] ? '#' : '.');
            }
        }

        std::cout << '\n';
    }

    return 0;
}