#include <iostream>
#include <iomanip>

int main() {
    double n;
    std::cin >> n;
    std::string ignore;
    getline(std::cin, ignore);

    std::string line2;
    getline(std::cin, line2);

    std::string word;
    std::cin >> word;

    std::cout << line2 << ": " << std::setprecision(3) << std::fixed << n << '\n' << word;
}