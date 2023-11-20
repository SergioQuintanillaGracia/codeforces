#include <iostream>
#include <climits>

int main() {
    while (true) {
        int cases;
        std::cin >> cases;

        if (cases == 0) break;

        int smallest = INT_MAX;

        for (int i = 0; i < cases; i++) {
            int heights;
            std::cin >> heights;

            int highest = INT_MIN;

            for (int j = 0; j < heights; j++) {
                int current;
                std::cin >> current;
                highest = (current > highest) ? current : highest;
            }

            smallest = (highest < smallest) ? highest : smallest;
        }

        std::cout << smallest << std::endl;
    }

    return 0;
}
