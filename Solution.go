
package main

import "fmt"

/*
Struct ListNode is in-built in the solution file on leetcode.com.
When running the code on the website, do not include this struct.
*/
type ListNode struct {
    Val  int
    Next *ListNode
}

const EMPTY = -1

var RIGHT = []int{0, 1}
var DOWN = []int{1, 0}
var LEFT = []int{0, -1}
var UP = []int{-1, 0}
var DIRECTIONS = [][]int{RIGHT, DOWN, LEFT, UP}

var rows = 0
var columns = 0
var matrixFilledInSpiralWay [][]int

func spiralMatrix(m int, n int, head *ListNode) [][]int {
    rows = m
    columns = n
    matrixFilledInSpiralWay = make([][]int, rows)
    for row := 0; row < rows; row++ {
        matrixFilledInSpiralWay[row] = make([]int, columns)
        for column := 0; column < columns; column++ {
            matrixFilledInSpiralWay[row][column] = EMPTY
        }
    }

    var row = 0
    var column = 0
    var indexDirections = 0
    var currentNode = head

    for currentNode != nil {
        matrixFilledInSpiralWay[row][column] = currentNode.Val

        nextRow := row + DIRECTIONS[indexDirections][0]
        nextColumn := column + DIRECTIONS[indexDirections][1]
        if !isInMatrix(nextRow, nextColumn) || isVisited(nextRow, nextColumn) {
            indexDirections = (indexDirections + 1) % len(DIRECTIONS)
        }

        row += DIRECTIONS[indexDirections][0]
        column += DIRECTIONS[indexDirections][1]
        currentNode = currentNode.Next
    }

    return matrixFilledInSpiralWay
}

func isInMatrix(row int, column int) bool {
    return row >= 0 && row < rows && column >= 0 && column < columns
}

func isVisited(row int, column int) bool {
    return matrixFilledInSpiralWay[row][column] != EMPTY
}
