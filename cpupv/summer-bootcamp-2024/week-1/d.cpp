#include <iostream>
#include <algorithm>
#include <cmath>

int main() {
    std::string in;
    std::getline(std::cin, in);

    std::transform(in.begin(), in.end(), in.begin(), tolower);
    std::cout << in << '\n';

    std::transform(in.begin(), in.end(), in.begin(), toupper);
    std::cout << in << '\n';
}
