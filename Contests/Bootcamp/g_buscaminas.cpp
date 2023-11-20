#include <iostream>
#include <vector>

using namespace std;

void printBoard(vector<vector<char>> inputBoard) {
    for (int row = 0; row < inputBoard.size(); row++) {
        for (int col = 0; col < inputBoard.at(0).size(); col++) {
            cout << inputBoard[row][col];
        }

        cout << endl;
    }
}


int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<char>> inputBoard;
    vector<vector<char>> board(n, vector<char>(m, ' '));

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;

        vector<char> sVector(s.begin(), s.end());
        inputBoard.push_back(sVector);
    }

    for (int row = 0; row < inputBoard.size(); row++) {
        for (int col = 0; col < inputBoard.at(0).size(); col++) {
            char current = inputBoard[row][col];
            
            if (current == '*') {
                board[row][col] = 'F';
            
            } else {
                int el7 = (row == 0 || col == 0) ? 0 : inputBoard[row - 1][col - 1] == '*' ? 1 : 0;
                int el8 = (row == 0) ? 0 : inputBoard[row - 1][col] == '*' ? 1 : 0;
                int el9 = (row == 0 || col == m - 1) ? 0 : inputBoard[row - 1][col + 1] == '*' ? 1 : 0;
                int el4 = (col == 0) ? 0 : inputBoard[row][col - 1] == '*' ? 1 : 0;
                int el6 = (col == m - 1) ? 0 : inputBoard[row][col + 1] == '*' ? 1 : 0;
                int el1 = (row == n - 1 || col == 0) ? 0 : inputBoard[row + 1][col - 1] == '*' ? 1 : 0;
                int el2 = (row == n - 1) ? 0 : inputBoard[row + 1][col] == '*' ? 1 : 0;
                int el3 = (row == n - 1 || col == m - 1) ? 0 : inputBoard[row + 1][col + 1] == '*' ? 1 : 0;

                int num = el7 + el8 + el9 + el4 + el6 + el1 + el2 + el3;

                char boardValue = num > 0 ? num + '0' : ' ';
                board[row][col] = boardValue;
            }
        }
    }

    printBoard(board);

    return 0;
}