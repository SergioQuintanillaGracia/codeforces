#include <bits/stdc++.h>

int main() {
    std::vector<int> vector1 {1, 2, 3, 4, 5};
    std::vector<int> vector2 = {1, 2, 3, 4, 5};
    vector2 = vector1;  // Copy the vector

    for (int i : vector1) {
        std::cout << i << " ";
    }

    std::cout << '\n';

    for (int i = 0; i < vector2.size(); i++) {
        std::cout << vector2.at(i) << " ";
    }

    std::cout << '\n';

    vector1.push_back(7);
    vector1.at(2) = 7;
    vector1.pop_back();
    vector1.erase(vector1.begin() + 2);  // Remove 3rd element (at pos 2)

    for (int i : vector1) {
        std::cout << i << " ";
    }
}