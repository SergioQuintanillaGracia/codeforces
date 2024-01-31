#include <iostream>

template<typename T>
void swap(T& a, T&b) {
    T temp = a;
    a = b;
    b = temp;
}

int main() {
    int a = 2;
    int b = 5;

    swap(a, b);

    std::cout << "a: " << a << " | b: " << b << std::endl;

    return 0;
}