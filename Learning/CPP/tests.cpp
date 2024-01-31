#include <iostream>

int main() {
    char c;

    std::cout << "Enter a character: ";
    c = std::cin.get();
    c = std::cin.get();
    c = std::cin.get();

    std::cout << "You typed: " << c << std::endl;
}