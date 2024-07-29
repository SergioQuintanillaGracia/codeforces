#include <iostream>

int main() {
    std::string word;
    int t;
    std::cin >> word >> t;

    std::cout << "Vienen a pasear: ";

    if (word == "Soleado" && t >= 20) {
        std::cout << "Adrian ";
    }

    if (word == "Soleado" || t > 15) {
        std::cout << "Barbara ";
    }

    if (word == "Soleado" || word == "Nublado") {
        std::cout << "Carmen ";
    }

    if (word != "Tormenta") {
        std::cout << "Dario ";
    }

    return 0;
}