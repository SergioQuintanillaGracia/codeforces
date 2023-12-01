#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    int a[100000], x[100000];
    int powersOf2[31];

    // Precompute the powers of 2 up to 30
    for (int i = 0; i < 31; i++) {
        powersOf2[i] = 1 << i;
    }

    while (t--) {
        int n, q;
        cin >> n >> q;

        // Fill the array a
        for (int j = 0; j < n; j++) {
            cin >> a[j];
        }

        // Fill the array x
        for (int j = 0; j < q; j++) {
            cin >> x[j];
        }

        // Modify the arrays according with the problem statement
        for (int j = 0; j < q; j++) {
            for (int k = 0; k < n; k++) {
                if (a[k] % powersOf2[x[j]] == 0) {
                    a[k] += powersOf2[x[j] - 1];
                }
            }
        }

        // Print the resulting array
        for (int j = 0; j < n; j++) {
            cout << a[j] << " ";
        }

        cout << endl;
    }

    return 0;
}