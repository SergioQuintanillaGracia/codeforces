#include <iostream>

#define PRINT_JOE
#define NUM_STR "31\n"

int main() {
    #ifdef PRINT_JOE
    std::cout << "Joe\n";
    #endif

    #ifdef PRINT_BOB
    std::cout << "Bob\n";
    #endif

    #ifndef PRINT_BOB
    std::cout << "Bob not defined\n";
    #endif

    #if 0   // #if 1 would compile everything inside the if
    std::cout << "This code won't compile\n"
    #endif

    std::cout << "The number is " << NUM_STR;

    return 0;
}