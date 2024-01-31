#include <iostream>
#include <algorithm>

template<typename T>
class Vector {
    size_t increments;
    T* data;
    size_t vCapacity;  // Current capacity of the Vector
    size_t vSize {0};  // Used elements of the Vector

public:
    Vector() : Vector(10) {}

    Vector(size_t increm) : increments(increm) {
        data = new T[increments];
        vCapacity = increments;
    }

    ~Vector() {
        delete[] data;
    }

    void add(T el) {
        if (vSize >= vCapacity) {
            // We need to expand the array
            T* newData = new T[vCapacity + increments];

            // Copy the data to the new array
            std::copy(data, data + vSize, newData);

            // Delete the previous data array and swap it by the new one
            delete[] data;
            data = newData;

            vCapacity += increments;
        }

        data[vSize++] = el;
    }

    void erase(size_t index) {
        if (index >= vSize()) {
            std::cout << "Error: The provided index is out of bounds. No element will be deleted.\n";
            return;
        }

        // Shift all the elements from index + 1 to vSize one to the left
        for (size_t i = index + 1; i < vSize; i++) {
            data[i - 1] = data[i];
        }

        vSize--;

        if (vSize + increments <= vCapacity) {
            // We can reduce the capacity of the vector
            T* newData = new T[vCapacity - increments];

            // Copy the data to the new array
            std::copy(data, data + vSize, newData);

            // Delete the previous array and swap it by the new one
            delete[] data;
            data = newData;

            vCapacity -= increments;
        }
    }

    void print() const {
        for (size_t i = 0; i < vSize; i++) {
            std::cout << data[i] << " ";
        }

        std::cout << std::endl;
    }

    size_t capacity() const {return vCapacity;}

    size_t size() const {return vSize;}
};

int main() {
    Vector<int> vec(2);
    vec.add(1);
    vec.add(4);
    vec.add(8);

    vec.print();
    std::cout << "Capacity: " << vec.capacity() << " | Size: " << vec.size() << std::endl;

    vec.erase(1);

    vec.print();
    std::cout << "Capacity: " << vec.capacity() << " | Size: " << vec.size() << std::endl;
}