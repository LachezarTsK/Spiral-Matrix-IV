
#include <array>
#include <vector>
using namespace std;

/*
The code will run faster with ios::sync_with_stdio(0).
However, this should not be used in production code and interactive problems.
In this particular problem, it is ok to apply ios::sync_with_stdio(0).

Many of the top-ranked C++ solutions for time on leetcode apply this trick,
so, for a fairer assessment of the time percentile of my code
you could outcomment the lambda expression below for a faster run.
*/

/*
const static auto speedup = [] {
    ios::sync_with_stdio(0);
    return nullptr;
}();
*/

/*
Struct ListNode is in-built in the solution file on leetcode.com. 
When running the code on the website, do not include this struct.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {

    inline static const int EMPTY = -1;
    static constexpr array<int, 2> RIGHT = { 0, 1 };
    static constexpr array<int, 2> DOWN = { 1, 0 };
    static constexpr array<int, 2> LEFT = { 0, -1 };
    static constexpr array<int, 2> UP = { -1, 0 };
    static constexpr array<array<int, 2>, 4> DIRECTIONS = { RIGHT, DOWN, LEFT, UP };

    int rows;
    int columns;
    vector<vector<int>> matrixFilledInSpiralWay;

public:
    vector<vector<int>> spiralMatrix(int rows, int columns, ListNode* head) {
        this->rows = rows;
        this->columns = columns;
        matrixFilledInSpiralWay.resize(rows, vector<int>(columns, EMPTY));

        int row = 0;
        int column = 0;
        int indexDirections = 0;
        ListNode* currentNode = head;

        while (currentNode != nullptr) {
            matrixFilledInSpiralWay[row][column] = currentNode->val;

            int nextRow = row + DIRECTIONS[indexDirections][0];
            int nextColumn = column + DIRECTIONS[indexDirections][1];
            if (!isInMatrix(nextRow, nextColumn) || isVisited(nextRow, nextColumn)) {
                indexDirections = (indexDirections + 1) % DIRECTIONS.size();
            }

            row += DIRECTIONS[indexDirections][0];
            column += DIRECTIONS[indexDirections][1];
            currentNode = currentNode->next;
        }

        return matrixFilledInSpiralWay;
    }

private:
    bool isInMatrix(int row, int column) const {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    bool isVisited(int row, int column) const {
        return matrixFilledInSpiralWay[row][column] != EMPTY;
    }
};
