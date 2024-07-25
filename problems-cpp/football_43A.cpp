#include <iostream>

int main() {
    int n;
    std::cin >> n;

    std::string t1, t2;
    std::cin >> t1;

    int t1Count = 1;
    int t2Count = 0;
    
    for (size_t i = 0; i < n - 1; i++) {
        std::string tCurr;
        std::cin >> tCurr;

        if (tCurr != t1) {
            if (t2.empty()) {
                t2 = tCurr;
            }
            t2Count++;
        } else {
            t1Count++;
        }
    }

    std::cout << (t1Count > t2Count ? t1 : t2) << '\n';

    return 0;
}