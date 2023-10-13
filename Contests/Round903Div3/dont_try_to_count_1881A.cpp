#include <iostream>
#include <string>

using namespace std;

int main() {
    int cases;
    string x, s;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int opCount;
        cin >> x >> s;
        cin >> x >> s;

        while (true) {
            if (x.find(s) != string::npos) {
                break;
            
            } else {
                x.append(x);
                opCount++;
            }

            if (x.length() / 100 > s.length()) {
                opCount = -1;
                break;
            }
        }

        cout << opCount << endl;
        
        opCount = 0;
    }

    return 0;
}