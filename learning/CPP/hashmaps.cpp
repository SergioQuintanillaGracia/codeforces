#include <bits/stdc++.h>

int main() {
    std::unordered_map<std::string, int> map;

    map["Apple"] = 10;
    map["Mango"] = 20;
    map["Cherry"] = 30;

    for (auto it : map) {
        std::cout << it.first << " " << it.second << std::endl;
    }
}