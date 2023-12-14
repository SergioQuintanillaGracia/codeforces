#include <iostream>
#include <vector>

using namespace std;

int findElement(vector<char> vec, char e);

int main() {
    int cases;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int n, k;
        string text;

        cin >> n >> k >> text;

        vector<char> chars;
        vector<int> charTimes;

        // Count the elements in text
        for (char c : text) {
            int elementIndex = findElement(chars, c);

            if (elementIndex != -1) {
                // If the element is in the vector, add 1 to the times it is repeated
                charTimes[elementIndex]++;
            
            } else {
                // If the element is not in the vector, add it and set its count to 1
                chars.push_back(c);
                charTimes.push_back(1);
            }
        }

        // Count the chars that are repeated an odd number of times
        int oddCount = 0;

        for (int i : charTimes) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }

        // If after removing k elements only one is repeated an odd number of times,
        // the word can be rearranged to a palindrome
        if (oddCount - k <= 1) {
            cout << "YES" << endl;
        
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}


int findElement(vector<char> vec, char e) {
    // Returns the index of the element in the vector, or -1 if it's not found
    for (int i = 0; i < vec.size(); i++) {
        if (vec[i] == e) {
            return i;
        }
    }

    return -1;
}