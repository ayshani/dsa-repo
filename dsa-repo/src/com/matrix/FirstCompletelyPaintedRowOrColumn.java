package com.matrix;

import java.util.HashMap;
import java.util.Map;

/*
2661. First Completely Painted Row or Column

You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.



Example 1:
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].

tc : o(m*n)
SC : o(m*n)
 */
public class FirstCompletelyPaintedRowOrColumn {

    public static void main(String[] args) {
        System.out.println(new FirstCompletelyPaintedRowOrColumn().firstCompleteIndex(
                new int[]{1,3,4,2}, new int[][]{{1,4},{2,3}}
        ));
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // Map to store the index of each number in the arr
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            numToIndex.put(arr[i], i);
        }

        int result = Integer.MAX_VALUE;
        int numRows = mat.length;
        int numCols = mat[0].length;

        // Check for the earliest row to be completely painted
        for (int row = 0; row < numRows; row++) {
            // Tracks the greatest index in this row
            int lastElementIndex = Integer.MIN_VALUE;
            for (int col = 0; col < numCols; col++) {
                int indexVal = numToIndex.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this row is fully painted
            result = Math.min(result, lastElementIndex);
        }

        // Check for the earliest column to be completely painted
        for (int col = 0; col < numCols; col++) {
            int lastElementIndex = Integer.MIN_VALUE;
            for (int row = 0; row < numRows; row++) {
                int indexVal = numToIndex.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this column is fully painted
            result = Math.min(result, lastElementIndex);
        }

        return result;
    }
}
