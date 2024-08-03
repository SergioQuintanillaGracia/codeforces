#include <iostream>

int main() {
    int n;
    std::cin >> n;

    int a1[n] = {0};
    int a2[n] = {0};

    for (int i = 0; i < n * 2; i++) {
        int d;
        std::cin >> d;

        if (i < n)
            a1[i] = d;
        else
            a2[i - n] = d;
    }

    bool first = true;

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < n; j++) {
            if (first) {
                std::cout << a1[j] << ' ';
                first = false;
            } else {
                std::cout << a2[j] << ' ';
                first = true;
            }
        }

        // After the first iteration of the loop, start again, but this time first starts
        // as false, so the first element of the second array goes first
        first = false;
        std::cout << '\n';
    }

    return 0;
}