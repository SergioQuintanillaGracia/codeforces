#include <iostream>

int binarySearch(int arr[], int size, int n) {
    int high = size - 1;
    int low = 0;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == n)
            return mid;
        if (n < arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return -1;
}

int main() {
    int arr[] = {4, 5, 9, 12, 17, 22, 40};

    std::cout << arr[binarySearch(arr, sizeof(arr) / sizeof(arr[0]), 17)] << std::endl;

    return 0;
}