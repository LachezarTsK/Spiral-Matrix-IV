
import java.util.Arrays;

public class Solution {

    private static final int EMPTY = -1;
    private static final int[] RIGHT = {0, 1};
    private static final int[] DOWN = {1, 0};
    private static final int[] LEFT = {0, -1};
    private static final int[] UP = {-1, 0};
    private static final int[][] DIRECTIONS = {RIGHT, DOWN, LEFT, UP};

    private int rows;
    private int columns;
    private int[][] matrixFilledInSpiralWay;

    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        this.rows = rows;
        this.columns = columns;
        this.matrixFilledInSpiralWay = new int[rows][columns];
        for (int row = 0; row < rows; ++row) {
            Arrays.fill(matrixFilledInSpiralWay[row], EMPTY);
        }

        int row = 0;
        int column = 0;
        int indexDirections = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            matrixFilledInSpiralWay[row][column] = currentNode.val;

            int nextRow = row + DIRECTIONS[indexDirections][0];
            int nextColumn = column + DIRECTIONS[indexDirections][1];
            if (!isInMatrix(nextRow, nextColumn) || isVisited(nextRow, nextColumn)) {
                indexDirections = (indexDirections + 1) % DIRECTIONS.length;
            }

            row += DIRECTIONS[indexDirections][0];
            column += DIRECTIONS[indexDirections][1];
            currentNode = currentNode.next;
        }

        return matrixFilledInSpiralWay;
    }

    private boolean isInMatrix(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private boolean isVisited(int row, int column) {
        return matrixFilledInSpiralWay[row][column] != EMPTY;
    }
}

/*
Class ListNode is in-built in the solution file on leetcode.com. 
When running the code on the website, do not include this class.
 */
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
