#include <iostream>

class Rectangle {
    private:
        int width, height;
    
    public:
        Rectangle(int w, int h) {
            width = w;
            height = h;
        }

        int area() {
            return width * height;
        }

        void resize(int w, int h) {
            width = w;
            height = h;
        }
};

int main() {
    Rectangle rect(10, 5);
    std::cout << "Area: " << rect.area() << std::endl;
    rect.resize(6, 4);
    std::cout << "New Area: " << rect.area() << std::endl;
    
    return 0;
}