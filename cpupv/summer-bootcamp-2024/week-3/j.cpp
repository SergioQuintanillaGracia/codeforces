#include <iostream>

int main() {
    std::string prev;
    std::string l;

    do {
        prev = l;
        getline(std::cin, l);
    } while (l != "");

    std::cout << prev;

    return 0;
}