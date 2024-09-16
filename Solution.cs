
using System;


public class Solution
{
    private static readonly int EMPTY = -1;
    private static readonly int[] RIGHT = { 0, 1 };
    private static readonly int[] DOWN = { 1, 0 };
    private static readonly int[] LEFT = { 0, -1 };
    private static readonly int[] UP = { -1, 0 };
    private static readonly int[][] DIRECTIONS = { RIGHT, DOWN, LEFT, UP };

    private int rows;
    private int columns;
    private int[][]? matrixFilledInSpiralWay;

    public int[][] SpiralMatrix(int rows, int columns, ListNode head)
    {
        this.rows = rows;
        this.columns = columns;
        this.matrixFilledInSpiralWay = new int[rows][];
        for (int r = 0; r < rows; ++r)
        {
            matrixFilledInSpiralWay[r] = new int[columns];
            Array.Fill(matrixFilledInSpiralWay[r], EMPTY);
        }

        int row = 0;
        int column = 0;
        int indexDirections = 0;
        ListNode currentNode = head;

        while (currentNode != null)
        {
            matrixFilledInSpiralWay[row][column] = currentNode.val;

            int nextRow = row + DIRECTIONS[indexDirections][0];
            int nextColumn = column + DIRECTIONS[indexDirections][1];
            if (!IsInMatrix(nextRow, nextColumn) || IsVisited(nextRow, nextColumn))
            {
                indexDirections = (indexDirections + 1) % DIRECTIONS.Length;
            }

            row += DIRECTIONS[indexDirections][0];
            column += DIRECTIONS[indexDirections][1];
            currentNode = currentNode.next;
        }

        return matrixFilledInSpiralWay;
    }

    private bool IsInMatrix(int row, int column)
    {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private bool IsVisited(int row, int column)
    {
        return matrixFilledInSpiralWay[row][column] != EMPTY;
    }
}
