#include <iostream>
#include <algorithm>

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
    int n;
    std::cin >> n;

    int books[n];

    for (size_t i = 0; i < n; i++) {
        std::cin >> books[i];
    }

    std::sort(books, books + n);

    int q;
    std::cin >> q;

    for (int i = 0; i < q; i++) {
        int book;
        std::cin >> book;

        if (binarySearch(books, n, book) != -1)
            std::cout << "YES\n";
        else
            std::cout << "NO\n";
    }

    return 0;
}