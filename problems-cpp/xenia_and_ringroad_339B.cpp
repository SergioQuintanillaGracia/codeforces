#include <iostream>

int main() {
    int n, m;
    std::cin >> n >> m;

    int curr = 1;
    std::int64_t time = 0;

    for (size_t i = 0; i < m; i++) {
        int next;
        std::cin >> next;

        if (next >= curr) {
            time += next - curr;
        } else {
            time += n - curr + next;
        }

        curr = next;
    }

    std::cout << time << std::endl;

    return 0;
}