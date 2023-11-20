#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> arr;
    
    arr.insert(arr.begin() + 0, 2);
    arr.insert(arr.begin() + 0, 3);
    arr.insert(arr.begin() + 2, 4);

    for (int i : arr) {
        cout << i << " ";
    }
    
    return 0;
}