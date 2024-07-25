#include <iostream>

struct Person {
    std::string name;
    int age;

    // Default constructor
    Person() : name("Unknown"), age(0) {};

    // Parameterized constructor
    Person(const std::string& n, int a) : name(n), age(a) {};

    // Copy constructor
    Person(const Person& other) : name(other.name), age(other.age) {
        std::cout << "Copied person named " << name << std::endl;
    }
};

int main() {
    Person person1;
    Person person2("Juan", 30);
    Person person3(person2);

    std::cout << "Person1: " << person1.name << ", " << person1.age << std::endl;
    std::cout << "Person2: " << person2.name << ", " << person2.age << std::endl;
    std::cout << "Person3: " << person3.name << ", " << person3.age << std::endl;

    return 0;
}