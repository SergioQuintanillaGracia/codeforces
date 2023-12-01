#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        string s;
        cin >> s;

        int toFill = 0;
        int consectEmpty = 0;
        
        for (int i = 0; i < s.size(); i++) {
            char c = s.at(i);

            if (c == '.') {
                toFill++;
                consectEmpty++;

                if (consectEmpty == 3) {
                    toFill = 2;
                    break;
                }

            } else {
                consectEmpty = 0;
            }
        }

        cout << toFill << endl;
        toFill = 0;
    }

    return 0;
}