#include <iostream>

int main() {
    std::string l;

    while (getline(std::cin, l)) {
        if (l.length() % 2 == 0) {
            for (int i = l.length() - 1; i >= 0; i--) {
                std::cout << l[i];
            }
        
        } else {
            std::cout << l;
        }

        std::cout << '\n';
    }

    return 0;
}