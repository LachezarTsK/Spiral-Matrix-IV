
function spiralMatrix(rows: number, columns: number, head: ListNode | null): number[][] {
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

function isInMatrix(row: number, column: number): boolean {
    return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
}

function isVisited(row: number, column: number): boolean {
    return this.matrixFilledInSpiralWay[row][column] !== this.EMPTY;
}

/*
Class ListNode is in-built in the solution file on leetcode.com. 
When running the code on the website, do not include this class.
 */
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}
