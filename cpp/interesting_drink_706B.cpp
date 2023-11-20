#include <iostream>
#include <vector>

using namespace std;

vector<int> shopPrices;

void binaryInsert(int num);

int main() {
    int count;
    cin >> count;

    for (int i = 0; i < count; i++) {
        int num;
        cin >> num;

        binaryInsert(num);
    }

    int shopCount;
    cin >> shopCount;

    for (int i = 0; i < shopCount; i++) {
        int ableToBuyCount = 0;
        int money;

        cin >> money;

        for (int j : shopPrices) {
            if (j <= money) ableToBuyCount++;
            else break;
        }

        cout << ableToBuyCount << endl;
        ableToBuyCount = 0;
    }

    return 0;
}


void binaryInsert(int num) {
    if (shopPrices.size() == 0) {
        shopPrices.insert(shopPrices.begin() + 0, num);

    } else if (shopPrices.size() == 1) {
        if (shopPrices.at(0) > num) {
            shopPrices.insert(shopPrices.begin(), num);
        
        } else {
            shopPrices.insert(shopPrices.begin() + 1, num);
        }
    
    } else {
        int min = 0;
        int max = shopPrices.size() - 1;

        while (max >= min) {
            int mid = (min + max) / 2;

            if (num < shopPrices[mid]) {
                max = mid - 1;
            
            } else if (num > shopPrices[mid]) {
                min = mid + 1;
            }
        }

        shopPrices.insert(shopPrices.begin() + min, num);
    }
}