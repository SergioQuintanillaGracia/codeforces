#include <iostream>
#include <memory.h>

#define LOG(x) std::cout << x << std::endl;

int main() {
    char* buffer = new char[8];
    memset(buffer, 0, 8);

    char** ptr = &buffer;

    delete[] buffer;
}