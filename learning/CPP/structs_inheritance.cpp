#include <iostream>

struct Animal {
    std::string name;
    int age;

    Animal(const std::string& n, int a) : name(n), age(a) {}

    void eat() const {
        std::cout << name << " is eating\n";
    }

    virtual void makeSound() const {
        std::cout << name << " makes a sound\n";
    }
};

struct Dog : Animal {
    std::string breed;

    Dog(const std::string& n, int a, const std::string& b) : Animal(n, a), breed(b) {}

    void makeSound() const override {
        std::cout << name << " barks\n";
    }

    void fetch() const {
        std::cout << name << " fetches the ball\n";
    }
};

int main() {
    Animal genericAnimal("Generic Animal", 5);
    genericAnimal.eat();
    genericAnimal.makeSound();

    Dog buddy("Buddy", 3, "Golden Retriever");
    buddy.eat();
    buddy.makeSound();
    buddy.fetch();

    return 0;
}