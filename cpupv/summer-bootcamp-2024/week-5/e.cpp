#include <iostream>
#include <algorithm>

bool comparator(const std::pair<int, int>& a, const std::pair<int, int>& b) {
    if (a.first == b.first)
        return a.second > b.second;
    return a.first < b.first;
}

int main() {
    int n;
    std::cin >> n;

    std::pair<int, int> arr[n];

    for (int i = 0; i < n; i++) {
        std::cin >> arr[i].first >> arr[i].second;
    }

    std::sort(arr, arr + n, comparator);

    while (--n >= 0) {
        std::cout << arr[n].first << ' ' << arr[n].second << '\n';
    }

    return 0;
}