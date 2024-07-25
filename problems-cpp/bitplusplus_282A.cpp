#include <iostream>

using namespace std;

int main() {
    int count;
    int x = 0;
    string input;

    cin >> count;
    
    for (int i = 0; i < count; i++) {
        cin >> input;
        
        if (input[1] == '+') x++;
        else x--;
    }

    cout << x;

    return 0;
}