#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream file("fibbonaci.txt");

    int a = 0;
    int b = 1;

    int n;
    cin >> n;
    cout << 1 << ", ";

    for (int i = 0; i < n; i++) {
        int newNum = a + b;

        a = b;  
        b = newNum;

        cout << newNum << (i != n - 1 ? ", " : "\n");

        file << newNum << endl;
    }

    file.close();

    return 0;
}