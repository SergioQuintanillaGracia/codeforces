#include <iostream>
#include <vector>

void merge(std::vector<int> &res, std::vector<int> &l1, std::vector<int> &l2) {
    int i1 = 0, i2 = 0;

    for (int i = 0; i < res.size(); i++) {
        if (l1.size() == i1) {
            res[i] = l2[i2++];
        } else if (l2.size() == i2) {
            res[i] = l1[i1++];
        } else if (l2[i2] < l1[i1]) {
            res[i] = l2[i2++];
        } else {
            res[i] = l1[i1++];
        }
    }
}

void mergeSort(std::vector<int> &l) {
    if (l.size() == 1) return;

    int mid = (l.size() / 2) - 1;
    std::vector<int> l1(l.begin(), l.begin() + mid + 1);
    std::vector<int> l2(l.begin() + mid + 1, l.begin() + l.size());

    mergeSort(l1);
    mergeSort(l2);

    merge(l, l1, l2);
}

int main() {
    int n;
    std::cin >> n;

    std::vector<int> vec;
    vec.reserve(n);

    for (size_t i = 0; i < n; i++) {
        int num;
        std::cin >> num;
        vec.push_back(num);
    }

    mergeSort(vec);

    for (size_t i = 0; i < n; i++) {
        std::cout << vec[i] << ' ';
    }

    return 0;
}