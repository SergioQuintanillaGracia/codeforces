#include <iostream>

int main() {
    int n, m;
    std::cin >> n >> m;
    std::string null;
    getline(std::cin, null);

    char arr[n][m];

    for (int i = 0; i < n; i++) {
        std::string l;
        getline(std::cin, l);

        for (int j = 0; j < m; j++) {
            arr[i][j] = l[j];
        }
    }

    bool isOriginal = true;

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < m - 1; j++) {
            char ref = arr[i][j];
            if (ref == arr[i + 1][j] && ref == arr[i][j + 1] && ref == arr[i + 1][j + 1]) {
                std::cout << "NO ORIGINAL";
                isOriginal = false;
                break;
            }
        }

        if (!isOriginal)
            break;
    }

    if (isOriginal)
        std::cout << "ORIGINAL";

    return 0;
}