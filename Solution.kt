
import java.util.Arrays

/*
Class ListNode is in-built in the solution file on leetcode.com.
When running the code on the website, do not include this class.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private companion object {
        const val EMPTY = -1
        val RIGHT = intArrayOf(0, 1)
        val DOWN = intArrayOf(1, 0)
        val LEFT = intArrayOf(0, -1)
        val UP = intArrayOf(-1, 0)
        val DIRECTIONS = arrayOf(RIGHT, DOWN, LEFT, UP)
    }

    private var rows = 0
    private var columns = 0
    private lateinit var matrixFilledInSpiralWay: Array<IntArray>

    fun spiralMatrix(rows: Int, columns: Int, head: ListNode?): Array<IntArray> {
        this.rows = rows
        this.columns = columns
        this.matrixFilledInSpiralWay = Array<IntArray>(rows) { IntArray(columns) }
        for (row in 0..<rows) {
            Arrays.fill(matrixFilledInSpiralWay[row], EMPTY)
        }

        var row = 0
        var column = 0
        var indexDirections = 0
        var currentNode = head

        while (currentNode != null) {
            matrixFilledInSpiralWay[row][column] = currentNode.`val`

            val nextRow = row + DIRECTIONS[indexDirections][0]
            val nextColumn = column + DIRECTIONS[indexDirections][1]
            if (!isInMatrix(nextRow, nextColumn) || isVisited(nextRow, nextColumn)) {
                indexDirections = (indexDirections + 1) % DIRECTIONS.size
            }

            row += DIRECTIONS[indexDirections][0]
            column += DIRECTIONS[indexDirections][1]
            currentNode = currentNode.next
        }

        return matrixFilledInSpiralWay
    }

    private fun isInMatrix(row: Int, column: Int): Boolean {
        return row in 0..<rows && column in 0..<columns
    }

    private fun isVisited(row: Int, column: Int): Boolean {
        return matrixFilledInSpiralWay[row][column] != EMPTY
    }
}
