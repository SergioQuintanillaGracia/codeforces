#include <iostream>

using namespace std;

bool isGood(string str) {
    char prev = str.at(0);

    for (int i = 1; i < str.length(); i++) {
        if (str.at(i) != prev) {
            prev = str.at(i);
        
        } else {
            return false;
        }
    }
    
    return true;
}


int main() {
    int cases;

    cin >> cases;

    for (int i = 0; i < cases; i++) {
        int temp;
        cin >> temp >> temp; // We don't need the lengths of the strings.

        string s, t;

        cin >> s >> t;

        if (isGood(s)) {
            cout << "Yes" << endl;
            continue;
        
        } else if (isGood(t)) {
            if (t.length() % 2 == 0) {
                cout << "No" << endl;
                continue;
            
            } else {
                // We check the times 0 is next to a 0, and 1 is next to a 1.
                int together0 = 0;
                int together1 = 0;
                char prev = s.at(0);

                for (int i = 1; i < s.length(); i++) {
                    if (s.at(i) == prev) {
                        if (prev == '0') {
                            together0++;
                        
                        } else {
                            together1++;
                        }
                    
                    } else {
                        prev = s.at(i);
                    }
                }

                if (together0 == 0 && t.at(0) == '0') {
                    cout << "Yes" << endl;
                    continue;
                
                } else if (together1 == 0 && t.at(0) == '1') {
                    cout << "Yes" << endl;
                    continue;

                } else {
                    cout << "No" << endl;
                }
            }
        
        } else {
            cout << "No" << endl;
            continue;
        }
    }

    return 0;
}