#include <iostream>
#include <memory.h>

using namespace std;

int main() {
    int rows = 5;
    int cols = 6;

    int arr[rows][cols];
    memset(arr, 0, sizeof(arr));

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            arr[i][j] = j + i + 1;
        }
    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cout << arr[i][j] << " ";
        }

        cout << endl;
    }

    return 0;
}