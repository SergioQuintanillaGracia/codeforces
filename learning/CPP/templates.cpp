#include <iostream>

template<typename T>
T add(T a, T b) {
    return a + b;
}

template<typename T>
struct BoxStruct {
    T data;

    BoxStruct(T d) : data(d) {}

    void print() const {
        std::cout << data << std::endl;
    }
};

template<typename T>
class BoxClass {
    T data;

public:
    BoxClass(T d) : data(d) {}

    void print() const {
        std::cout << data << std::endl;
    }
};

int main() {
    std::cout << add<int>(1, 2) << std::endl;
    std::cout << add<double>(1.5, 2.2) << std::endl;
    std::cout << add<std::string>("Hello, ", "World") << std::endl;

    BoxStruct<int> intBox(2);
    BoxStruct<double> doubleBox(1.23);

    intBox.print();
    doubleBox.print();

    BoxClass<int> intBoxC(2);
    BoxClass<double> doubleBoxC(1.23);

    intBoxC.print();
    doubleBoxC.print();

    return 0;
}