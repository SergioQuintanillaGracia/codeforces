#include <iostream>
#include <vector>

int main() {
    int n, k;
    std::cin >> n >> k;

    int arr[n];

    int minSum = 0;
    int minIndex = 0;
    int currSum;
    
    // Get the input and fill the array.
    for (size_t i = 0; i < n; i++) {
        std::cin >> arr[i];

        if (i == k - 1) {
            for (size_t j = i; j < i + k; j++) {
                minSum += arr[j];
            }
            
            currSum = minSum;
            minIndex = i - k + 1;
        }

        if (i >= k) {
            // Check if the last k elements of the array sum less than
            // the previous sum of the last k elements
            currSum -= arr[i - k];

            currSum += arr[i];

            if (currSum < minSum) {
                minSum = currSum;
                minIndex = i - k + 1;
            }
        }
    }

    std::cout << minIndex + 1 << '\n';

    return 0;
}