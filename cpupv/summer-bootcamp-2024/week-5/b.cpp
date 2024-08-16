#include <iostream>
#include <algorithm>
#include <limits.h>

int main() {
    int n;
    std::cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++) {
        std::cin >> arr[i];
    }

    std::sort(arr, arr + n);

    int min = INT_MAX;

    for (int i = 0; i < n - 1; i++) {
        int diff = arr[i + 1] - arr[i];
        
        if (diff < min)
            min = diff;
    }

    std::cout << min;

    return 0;
}