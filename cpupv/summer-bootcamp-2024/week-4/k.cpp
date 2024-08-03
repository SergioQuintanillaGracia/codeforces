#include <iostream>

bool inBounds(int n, int m, int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
}

int main() {
    int n, m;
    std::cin >> n >> m;

    char arr[n][m];

    for (int i = 0; i < n; i++) {
        std::string l;
        std::cin >> l;

        for (int j = 0; j < m; j++) {
            arr[i][j] = l[j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int count = 0;

            if (arr[i][j] == '*') {
                std::cout << "F";
                continue;
            }

            // Count the mines around the spot
            for (int k = i - 1; k <= i + 1; k++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (k != n && l != m) {
                        if (inBounds(n, m, k, l)) {
                            if (arr[k][l] == '*')
                                count++;
                        }
                    }
                }
            }
        
            // NOTE: In the false expression, we are adding '0' (which is 48 in int) to count, and
            // then converting that to a character
            // As the maximum mine count around a spot is 8, the range of characters returned is
            // [48, 56], which as characters is ['0', '8']
            // We can't put `count` as false expression because that would mean the ternary operator
            // returns an int, and therefore when the condition is true, ' ' would be converted to
            // int, and 32 will be printed
            std::cout << (count == 0 ? ' ' : static_cast<char>(count + '0'));
        }

        std::cout << '\n';
    }

    return 0;
}