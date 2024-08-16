#include <iostream>

void selectionSort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        int minI = i;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minI]) {
                minI = j;
            }
        }

        std::swap(arr[minI], arr[i]);
    }
}

int main() {
    int n;
    std::cin >> n;

    int arr[n];

    for (size_t i = 0; i < n; i++) {
        std::cin >> arr[i];
    }

    selectionSort(arr, n);

    for (size_t i = 0; i < n; i++) {
        std::cout << arr[i] << ' ';
    }

    return 0;
}