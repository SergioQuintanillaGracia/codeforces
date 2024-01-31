#include <iostream>
#include <vector>

void addEdge(int x, int y, std::vector<std::vector<int>>& adj) {
    adj[x].push_back(y);
    adj[y].push_back(x);
}