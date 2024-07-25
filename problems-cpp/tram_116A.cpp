#include <iostream>

using namespace std;

int main() {
    int count;
    int max = 0;
    int current = 0;

    cin >> count;

    for (int i = 0; i < count; i++) {
        int a, b;
        cin >> a >> b;

        current += b - a;

        if (current > max) {
            max = current;
        }
    }

    cout << max << endl;

    return 0;
}