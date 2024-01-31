#include <iostream>
#include <vector>

int main() {
    std::vector<int> vector1 {1, 2, 3, 4, 5};
    std::vector<int> vector2 = {1, 2, 3, 4, 5};
    std::vector<int> vector3(5, 12);  // Here, 5 is the size, and 12 is the number used to fill the vector

    // First way to loop through the vector
    for (int i : vector1) {
        std::cout << i << " ";
    }

    std::cout << '\n';

    // Second way
    for (int i = 0; i < vector2.size(); i++) {
        // We can also do vector2[i], but if i is out of bounds, it will return a garbage value
        std::cout << vector2.at(i) << " ";
    }

    std::cout << '\n';

    // Third way, safer and more efficient
    for (const int& i : vector3) {
        std::cout << i << " ";
    }

    std::cout << '\n';


    // VECTOR OPERATIONS
    
    // Add an element
    vector1.push_back(7);

    // Change element at index 2
    vector1.at(2) = 9;

    // Remove the last element in the vector (the rightmost element)
    vector1.pop_back();

    
    // USEFUL FUNCTIONS

    vector1.size();      // Amount of elements in the vector
    vector1.clear();     // Clear the vector
    vector1.front();     // First element of the vector
    vector1.back();      // Last element of the vector
    vector1.empty();     // Returns 1 / true if the vector is empty
    vector1.capacity();  // Returns the size of the vector

    std::cout << vector1.capacity() << " - capacity\n";

    return 0;
}