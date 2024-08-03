#include <iostream>

int main() {
    int n;
    std::cin >> n;

    char arr[n][n];
    bool hasJelly = false;

    for (int i = 0; i < n; i++) {
        std::string line;
        std::cin >> line;
        
        for (int j = 0; j < line.length(); j++) {
            if (line[j] == '#')
                hasJelly = true;

            arr[i][j] = line[j];
        }
    }

    if (!hasJelly) {
        std::cout << "NO LLEVABA MERMELADA";

    } else {
        bool isTragedia = false;                // Tragedia...

        for (int i = 0; i < n; i++) {
            std::string line;
            std::cin >> line;
            
            for (int j = 0; j < line.length(); j++) {
                if (line[j] != arr[i][j]) {
                    std::cout << "TRAGEDIA";    // Tragedia...
                    isTragedia = true;          // Tragedia...
                    break;
                }
            }

            if (isTragedia)
                break;
        }

        if (!isTragedia) {
            std::cout << "HA HABIDO SUERTE";
        }
    }

    return 0;
}