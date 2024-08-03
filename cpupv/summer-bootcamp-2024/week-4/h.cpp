#include <iostream>

int main() {
    int r, c;
    std::cin >> r >> c;

    int arr[r][c];
    int highest = 0;
    int currSum = 0;

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            int n;
            std::cin >> n;
            arr[i][j] = n;

            // At the same time we get the input, calculate the sum of the current row
            currSum += n;
        }

        if (currSum > highest)
            highest = currSum;
        
        currSum = 0;
    }

    // Check if the sum of any column is greater
    for (int i = 0; i < c; i++) {
        for (int j = 0; j < r; j++) {
            currSum += arr[j][i];
        }

        if (currSum > highest)
            highest = currSum;
        
        currSum = 0;
    }

    std::cout << highest;

    return 0;
}