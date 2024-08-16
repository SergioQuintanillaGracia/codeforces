#include <iostream>
#include <algorithm>

int main() {
    int n;
    std::cin >> n;

    std::pair<int, std::string> arr[n];

    for (int i = 0; i < n; i++) {
        std::cin >> arr[i].first >> arr[i].second;
    }

    std::sort(arr, arr + n);

    for (int i = 0; i < n; i++) {
        std::cout << arr[i].first << ' ' << arr[i].second << '\n';
    }

    return 0;
}