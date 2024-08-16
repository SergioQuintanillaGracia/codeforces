#include <iostream>

void selectionSort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        bool swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                std::swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }

        if (!swapped) {
            // No more swaps have been done, the array is already
            // sorted
            break;
        }
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