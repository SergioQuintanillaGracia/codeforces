#include <iostream>

struct Resource {
    std::string owner;
    
    // Constructor of Resource
    Resource(std::string o) : owner(o) {
        std::cout << "Resource of " << owner << " acquired\n";
    }

    // Destructor of Resource
    ~Resource() {
        std::cout << "Resource of " << owner << " released\n";
    }
};

struct Person {
    std::string name;
    int age;
    Resource resource;  // Composition: Person 'has-a' Resource ('has-a' is a type of relationship (Composition))

    // Constructor of Person that initializes its name, age and resource
    Person(const std::string& n, int a) : name(n), age(a), resource(name) {}

    ~Person() {
        std::cout << name << " has been destroyed\n";
    }

    // Member function
    void greet(int times) const {
        // const means it will not modify any member variable of the Person object
        // It allows the function to be executed from const objects of the type Person
        // It is also important because it prevents accidental modifications of the object
        std::cout << name << " is greeting " << times << " times\n";
    }
};

int main() {
    // Creating an object of Person on the stack (automatic storage)
    // Its destructor is called automatically when it goes out of scope
    Person alice("Alice", 30);

    // Creating an object of Person on the heap (dynamic storage)
    // It must be manually deleted to avoid memory leaks
    Person* juan = new Person("Juan", 27);

    std::cout << "Deleting Juan\n";

    // Manually deleting the dynamically allocated object
    // This calls the destructor of 'juan' and deallocates memory
    delete juan;

    std::cout << "Got to the end\n";
    return 0;
}