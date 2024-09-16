
/**
 * @param {number} rows
 * @param {number} columns
 * @param {ListNode} head
 * @return {number[][]}
 */
var spiralMatrix = function (rows, columns, head) {
    this.EMPTY = -1;
    this.RIGHT = [0, 1];
    this.DOWN = [1, 0];
    this.LEFT = [0, -1];
    this.UP = [-1, 0];
    this.DIRECTIONS = [this.RIGHT, this.DOWN, this.LEFT, this.UP];

    this.rows = rows;
    this.columns = columns;
    this.matrixFilledInSpiralWay = Array.from(new Array(rows), () => new Array(columns).fill(this.EMPTY));

    let row = 0;
    let column = 0;
    let indexDirections = 0;
    let currentNode = head;

    while (currentNode !== null) {
        this.matrixFilledInSpiralWay[row][column] = currentNode.val;

        const nextRow = row + this.DIRECTIONS[indexDirections][0];
        const nextColumn = column + this.DIRECTIONS[indexDirections][1];
        if (!isInMatrix(nextRow, nextColumn) || isVisited(nextRow, nextColumn)) {
            indexDirections = (indexDirections + 1) % this.DIRECTIONS.length;
        }

        row += this.DIRECTIONS[indexDirections][0];
        column += this.DIRECTIONS[indexDirections][1];
        currentNode = currentNode.next;
    }

    return this.matrixFilledInSpiralWay;

};

/**
 * @param {number} row
 * @param {number} column
 * @return {boolean}
 */
function isInMatrix(row, column) {
    return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
}

/**
 * @param {number} row
 * @param {number} column
 * @return {boolean}
 */
function isVisited(row, column) {
    return this.matrixFilledInSpiralWay[row][column] !== this.EMPTY;
}

/*
 Function ListNode is in-built in the solution file on leetcode.com. 
 When running the code on the website, do not include this function.
 */
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}
