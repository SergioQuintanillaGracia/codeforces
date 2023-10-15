#include <iostream>

using namespace std;

int tryValue(int max, int val) {
    return val > max ? val : max;
}

int main() {
    int a, b, c;
    int max;
    
    cin >> a >> b >> c;

    max = a + b + c;
    max = tryValue(max, a + b * c);
    max = tryValue(max, a * b + c);
    max = tryValue(max, a * b * c);
    max = tryValue(max, (a + b) * c);
    max = tryValue(max, a * (b + c));

    cout << max << endl; 

    return 0;
}