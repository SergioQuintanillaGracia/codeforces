#include <iostream>

int main() {
    int p, v;
    int sum = 0;
    std::cin >> p >> v;

    while (p-- > 0) {
        for (int i = 0; i < v; i++) {
            char w1, w2;
            std::cin >> w1 >> w2;

            if (w1 == '#' || w2 == '#')
                sum++;
        }
    }

    std::cout << sum;

    return 0;
}